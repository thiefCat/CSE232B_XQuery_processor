package main;

import java.io.*;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.*;
import java.util.*;
import main.antlr.XQueryParser;
import main.antlr.XQueryLexer;

import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XQueryReWriter {
    static void rewrite(String XQueryFileName, String rewrittenFileName, String xmlFileName) throws Exception {
        // rewrite XQueryFile and save it to rewrittenFile
        XQueryLexer lexer = new XQueryLexer(new ANTLRFileStream(XQueryFileName));
        XQueryParser parser = new XQueryParser(new CommonTokenStream(lexer));
        ParseTree ast = parser.xquery();
        Document document = XMLParser.loadXML(xmlFileName);
        String rewrittenResStr = evaluate(ast, document, new HashMap<>());
        // System.out.println("rewrittenResStr: " + rewrittenResStr);

        // save to rewrittenFile
        Path rewrittenFilePath = Paths.get(rewrittenFileName);
        Path parentDir = rewrittenFilePath.getParent();
        if (parentDir != null && !Files.exists(parentDir)) {
            Files.createDirectories(parentDir);
        }
        File rewrittenFile = new File(rewrittenFileName);
        try(FileWriter fileWriter = new FileWriter(rewrittenFile);
        ){
            fileWriter.write(rewrittenResStr);
        }

    }

    public static String evaluate(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        if (ast instanceof XQueryParser.FlwrXQueryContext) {
            return handleFLWRXQuery((XQueryParser.FlwrXQueryContext) ast, currentNode, context);
        }
        return "";
    }
    
    private static String handleFLWRXQuery(XQueryParser.FlwrXQueryContext flwrCtx, Node currentNode, Map<String, List<Node>> context) {
        HashMap<String, Integer> variableGroupMap = new HashMap<>();
        HashMap<String, Integer> variableIndexMap = new HashMap<>();
        HashMap<Integer, LinkedList<String>> groupedVariables = new HashMap<> ();

        for(int i = 0; i < flwrCtx.forClause().var().size(); ++ i){
            String var = flwrCtx.forClause().var(i).getText();
            String path = flwrCtx.forClause().xquery(i).getText();

            variableIndexMap.put(var, i);

            if(path.substring(0, 1).equals("$")){
                String parentVar = path.split("/")[0];
                variableGroupMap.put(var, variableGroupMap.get(parentVar));
            }else{
                // the first variable of this group
                variableGroupMap.put(var, i);
            }
            Integer groupIndex = variableGroupMap.get(var);
            if(!groupedVariables.containsKey(groupIndex)){
                groupedVariables.put(groupIndex, new LinkedList<>());
            }
            groupedVariables.get(groupIndex).add(var);
        }

        HashMap<Integer, LinkedList<String[]>> groupConstConditions = new HashMap<> ();
        HashMap<String, LinkedList<String []>> groupVarsConditions = new HashMap<> ();
        String [] equalCondition;
        for(int i = 0; i < flwrCtx.whereClause().getText().substring(5).split("and").length; ++ i){
            String currentCondition = flwrCtx.whereClause().getText().substring(5).split("and")[i];

            if (currentCondition.contains("eq$")){
                equalCondition = currentCondition.split("eq\\$");
                equalCondition[1] = "$" + equalCondition[1];
            }else if(currentCondition.contains("=")){
                equalCondition = currentCondition.split("=");
            }else {
                equalCondition = currentCondition.split("eq\"");
                equalCondition[1] = "\"" + equalCondition[1];
            }

            if(!currentCondition.contains("\"")){
                int gp1 = variableGroupMap.get(equalCondition[0]);
                int gp2 = variableGroupMap.get(equalCondition[1]);

                if(gp1 != gp2) {
                    if(gp1 > gp2) {
                        int temp = gp1;
                        gp1 = gp2;
                        gp2 = temp;
                        String tempString = equalCondition[0];
                        equalCondition[0] = equalCondition[1];
                        equalCondition[1] = tempString;
                    }
                    String key = gp1 + "," + gp2;
                    if (!groupVarsConditions.containsKey(key)) {
                        groupVarsConditions.put(key, new LinkedList<>());
                    }
                    groupVarsConditions.get(key).add(equalCondition);
                }else{
                    if (!groupConstConditions.containsKey(gp1)){
                        groupConstConditions.put(gp1, new LinkedList<>());
                    }
                    groupConstConditions.get(gp1).add(equalCondition);
                }
            }
            else{
                boolean isFirstConstant = equalCondition[0].substring(0, 1).equals("\"");
                boolean isSecondConstant = equalCondition[1].substring(0, 1).equals("\"");

                if(!(isFirstConstant && isSecondConstant)) {
                    int gp;
                    if(isFirstConstant) {
                        gp = variableGroupMap.get(equalCondition[1]);
                    }else {
                        gp = variableGroupMap.get(equalCondition[0]);
                    }

                    if(!groupConstConditions.containsKey(gp)) {
                        groupConstConditions.put(gp, new LinkedList<>());
                    }
                    groupConstConditions.get(gp).add(equalCondition);
                }
                else{// can be deleted
                    for (Integer key : groupedVariables.keySet()) {
                        if(!groupConstConditions.containsKey(key)){
                            groupConstConditions.put(key, new LinkedList<>());
                        }
                        groupConstConditions.get(key).add(equalCondition);
                    }
                }
            }
        }

        HashMap<Integer, String> groupedForStatements = new HashMap<> ();
        for (Map.Entry<Integer, LinkedList<String>> set : groupedVariables.entrySet()) {
            int currentGroup = set.getKey();

            String forClauseStr = "for " + flwrCtx.forClause().var(currentGroup).getText() + " in " + flwrCtx.forClause().xquery(currentGroup).getText() + ",\n";
            for (String curVar : set.getValue()) {
                int curIndex =  variableIndexMap.get(curVar);
                if (currentGroup != curIndex) {
                    forClauseStr += curVar + " in " + flwrCtx.forClause().xquery(curIndex).getText() + ",\n";
                }
            }

            forClauseStr = forClauseStr.substring(0, forClauseStr.length() - 2);
            forClauseStr += "\n";
            groupedForStatements.put(currentGroup, forClauseStr);
        }

        for (Map.Entry<Integer, LinkedList<String[]>> set : groupConstConditions.entrySet()) {
            int currentGroup = set.getKey();
            String forClauseStr = groupedForStatements.get(currentGroup);
            forClauseStr += "where ";
            for (String[] eqCond : set.getValue()) {
                forClauseStr += eqCond[0] + " eq " + eqCond[1] + " and ";
            }
            forClauseStr = forClauseStr.substring(0, forClauseStr.length() - 5);
            forClauseStr += "\n";
            groupedForStatements.put(currentGroup, forClauseStr);
        }

        for (Map.Entry<Integer, LinkedList<String>> set : groupedVariables.entrySet()) {
            int currentGroup = set.getKey();
            String forClauseStr = groupedForStatements.get(currentGroup);
            forClauseStr += "return <tuple>{ ";
            for (String curVar : set.getValue()){
                forClauseStr += String.format("<%s>{%s}</%s>, ", curVar.substring(1), curVar, curVar.substring(1));
            }
            forClauseStr = forClauseStr.substring(0, forClauseStr.length() - 2);
            forClauseStr += " }</tuple>,\n";
            groupedForStatements.put(currentGroup, forClauseStr);
        }

        HashMap<HashSet<Integer>, String> mergedResults = new HashMap<>();
        joinQueryResults(mergedResults, groupVarsConditions, groupedForStatements);

        String finalQuery = "for $tuple in ";
        String finalJoinString= mergedResults.values().toString();
        finalJoinString= finalJoinString.substring(1, finalJoinString.length() - 3);
        finalQuery += finalJoinString+ "\n";

        boolean isVariable = false;
        String returnClauseStr = flwrCtx.returnClause().getText();

        for (int i = 0; i < returnClauseStr.length(); i++) {

            char currentChar = returnClauseStr.charAt(i);
            if (!Character.isDigit(currentChar) && !Character.isLetter(currentChar) && isVariable) {
                returnClauseStr = returnClauseStr.substring(0, i) + "/*)" + returnClauseStr.substring(i);
                isVariable = false;
            }
            if (currentChar == '$') {
                isVariable = true;
            }
        }
        returnClauseStr = returnClauseStr.replace("$", "($tuple/");
        finalQuery += returnClauseStr;

        return finalQuery;
    }

    private static void joinQueryResults(HashMap<HashSet<Integer>, String> mergedResults, HashMap<String, LinkedList<String[]>> groupVarsConditions, HashMap<Integer, String> groupedForStatements){
        for (Integer gp : groupedForStatements.keySet()) {
            HashSet<Integer> newList = new HashSet<>();
            newList.add(gp);
            mergedResults.put(newList, groupedForStatements.get(gp));
        }
        for (String key : groupVarsConditions.keySet()) {
            HashSet<Integer> newList = new HashSet<>();
            String finalJoinString= "join (\n";
            String groupQuery1 = "";
            String groupQuery2 = "";

            int gp1 = Integer.valueOf(key.split(",")[0]);
            int gp2 = Integer.valueOf(key.split(",")[1]);

            for (HashSet<Integer> lKey : mergedResults.keySet()) {
                if (lKey.contains(gp1)) {
                    groupQuery1 = mergedResults.get(lKey);
                    mergedResults.remove(lKey);
                    newList.addAll(lKey);
                    break;
                }
            }

            for (HashSet<Integer> lKey : mergedResults.keySet()) {
                if (lKey.contains(gp2)) {
                    groupQuery2 = mergedResults.get(lKey);
                    mergedResults.remove(lKey);
                    newList.addAll(lKey);
                    break;
                }
            }

            String joinKeys1 = "[", joinKeys2 = "[";
            finalJoinString+= groupQuery1 + "\n" + groupQuery2 + "\n";

            for (String[] eqCond : groupVarsConditions.get(key)) {
                joinKeys1 += eqCond[0].substring(1) + ",";
                joinKeys2 += eqCond[1].substring(1) + ",";
            }

            joinKeys1 = joinKeys1.substring(0, joinKeys1.length() - 1) + "], ";
            joinKeys2 = joinKeys2.substring(0, joinKeys2.length() - 1) + "]";
            finalJoinString+= joinKeys1 + joinKeys2;
            finalJoinString+= "),\n";

            mergedResults.put(newList, finalJoinString);
        }
    }
}