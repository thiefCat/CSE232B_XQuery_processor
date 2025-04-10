package main;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.*;
import java.util.*;
import main.antlr.XQueryParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XQueryProcessor {
    static Document tmpDoc = null;

    public static Document compute(Document document, ParseTree ast) throws Exception {

        if (ast instanceof XQueryParser.ApXQueryContext) {
            // a Xpath
            return XPathProcessor.compute(document, ast.getChild(0));
        } else {
            // a Xquery for MileStone III
            Map<String, List<Node>> emptyContext = new HashMap<>();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            tmpDoc = builder.newDocument();
            List<Node> resultNodes;
            if (document.getDocumentElement().getTagName().equals("data")) {
                resultNodes = evaluate(ast, document.getFirstChild(), emptyContext);
            } else {
                resultNodes = evaluate(ast, document, emptyContext);
            }
            

            /*
            if (resultNodes == null || resultNodes.isEmpty()) {
                return tmpDoc;
            }
            Node root = resultNodes.get(0);
            Node importedRoot = tmpDoc.importNode(root, true);
            tmpDoc.appendChild(importedRoot);
            return tmpDoc;
            */

            Element rootElement = tmpDoc.createElement("result");
            tmpDoc.appendChild(rootElement);
            for(Node node : resultNodes){
                Node importedNode = tmpDoc.importNode(node, true);
                rootElement.appendChild(importedNode);
            }
            return tmpDoc;


        }
    }

    public static List<Node> evaluate(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        if (ast instanceof XQueryParser.FlwrXQueryContext) {
            return handleFLWRXQuery((XQueryParser.FlwrXQueryContext) ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.BraceXQueryContext) {
            return handleBraceXQuery(ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.CommaXQueryContext) {
            return handleCommaXQuery(ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.TagXQueryContext) {
            return handleTagXQuery(ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.ApXQueryContext) {
            return handleApXQuery(ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.VarXQueryContext) {
            return handleVarXQuery(ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.ScXQueryContext) {
            return handleScXQuery((XQueryParser.ScXQueryContext) ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.SingleSlashXQueryContext) {
            return handleSingleSlashXQuery((XQueryParser.SingleSlashXQueryContext) ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.DoubleSlashXQueryContext) {
            return handleDoubleSlashXQuery((XQueryParser.DoubleSlashXQueryContext) ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.LetXQueryContext) {
            return handleLetXQuery((XQueryParser.LetXQueryContext) ast, currentNode, context);
        }

        // # joinXQuery
        if (ast instanceof XQueryParser.JoinXQueryContext) {
            return handleJoinXQuery((XQueryParser.JoinXQueryContext) ast, currentNode, context);
        }

        return null;
    }

    private static Element makeElement(String tagName, List<Node> children) {
        try {
            Element newElem = tmpDoc.createElement(tagName);
            for (Node child : children) {
                Node importedChild = tmpDoc.importNode(child, true); // true => deep copy
                newElem.appendChild(importedChild);
            }
            return newElem;

        } catch (Exception e) {
            throw new RuntimeException("Error creating new element for tag: " + tagName, e);
        }
    }

    private static Node makeText(String text) {
        try {
            Node newNode = tmpDoc.createTextNode(text);
            return newNode;
        } catch (Exception e) {
            throw new RuntimeException("Error creating new textNode for text: " + text, e);
        }
    }

    private static Map<String, List<Node>> extendContext(Map<String, List<Node>> prevCtx, String varName, List<Node> items) {
        Map<String, List<Node>> newContext = new HashMap<>(prevCtx);
        newContext.put(varName, items);
        return newContext;
    }

    private static List<Node> handleLetXQuery(XQueryParser.LetXQueryContext letXQCtx, Node currentNode, Map<String, List<Node>> context) {
        XQueryParser.LetClauseContext letCtx = letXQCtx.letClause();
        ParseTree xquery = letXQCtx.xquery();
        List<Map<String, List<Node>>> inputCtxList = new ArrayList<>();
        inputCtxList.add(context);
        // Extend context by evaluating the letClause
        List<Map<String, List<Node>>> extendedCtxList = handleLetClause(letCtx, currentNode, inputCtxList);
        Map<String, List<Node>> newCtx = extendedCtxList.get(0);
        List<Node> result = new ArrayList<>();
        result.addAll(evaluate(xquery, currentNode, newCtx));
        return result;
    }

    /**
     * Builds a key string from a tuple and a list of condition identifiers.
     */
    private static String buildKeyFromConditions(Node tuple, String[] conditionsList) {
        // Convert the tuple's child nodes into a List<Node> for easier iteration.
        List<Node> cols = convertNodeListToList(tuple.getChildNodes());
        
        StringBuilder key = new StringBuilder();
        // For each field name in the conditions list, find the matching node and append its text content.
        for(String fieldName : conditionsList) {
            for(Node col : cols) {
                if(fieldName.equals(col.getNodeName())) {
                    key.append(col.getChildNodes().item(0).getTextContent());
                }
            }
        }
        return key.toString();
    }

    private static List<Node> convertNodeListToList(NodeList nodeList) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            list.add(nodeList.item(i));
        }
        return list;
    }

    private static List<Node> handleJoinXQuery(XQueryParser.JoinXQueryContext joinXQCtx, Node currentNode, Map<String, List<Node>> context) {
        // Hash Join
        List<Node> list0 = evaluate(joinXQCtx.xquery(0), currentNode, context);
        List<Node> list1 = evaluate(joinXQCtx.xquery(1), currentNode, context);

        // Build the condition Lists
        int conditionsListLen = joinXQCtx.idList(0).ID().size();
        String[] conditionsList0 = new String[conditionsListLen];
        String[] conditionsList1 = new String[conditionsListLen];
        for(int i = 0; i < conditionsListLen; ++ i){
            conditionsList0[i] = joinXQCtx.idList(0).ID(i).getText();
            conditionsList1[i] = joinXQCtx.idList(1).ID(i).getText();
        }

        // Based on list0, build a hash table
        HashMap<String, List<Node>> hashmap= new HashMap<String, List<Node>>();
        for(Node tuple : list0){
            String key = buildKeyFromConditions(tuple, conditionsList0);

            if(hashmap.containsKey(key)){
                hashmap.get(key).add(tuple);
            }else{
                List<Node> value = new LinkedList<> ();
                value.add(tuple);
                hashmap.put(key, value);
            }
        }

        // iterate through list1, do join
        List<Node> result = new LinkedList<>();

        for(Node tuple:list1){
            String key = buildKeyFromConditions(tuple, conditionsList1);

            if(hashmap.containsKey(key)) {
                // Join!
                List<Node> joinedCol = new LinkedList<>();

                for(Node node0: hashmap.get(key)){
                    List<Node> cols0 = convertNodeListToList(node0.getChildNodes());
                    List<Node> cols1 = convertNodeListToList(tuple.getChildNodes());
                    cols0.addAll(cols1);

                    joinedCol.add(makeElement("tuple", cols0));
                }
                result.addAll(joinedCol);
            }
        }

        return result;
    }

    private static List<Node> handleScXQuery(XQueryParser.ScXQueryContext scCtx, Node currentNode, Map<String, List<Node>> context) {
        String str = scCtx.STRING().getText();
        // TODO: Try deleting it
        str = str.substring(1, str.length() - 1);

        List<Node> res = new LinkedList<>();
        res.add(tmpDoc.createTextNode(str));
        return res;
    }

    private static List<Node> handleSingleSlashXQuery(XQueryParser.SingleSlashXQueryContext singleSlashCtx,
                                                      Node currentNode,
                                                      Map<String, List<Node>> context) {
        // 1. Evaluate the left XQuery (XQ1)
        List<Node> leftResults = evaluate(singleSlashCtx.xquery(), currentNode, context);
        List<Node> finalResults = new ArrayList<>();

        // 2. For each node in the leftResults, evaluate rp
        ParseTree rpAst = singleSlashCtx.relativePath(); // or singleSlashCtx.getChild(2)
        for (Node n : leftResults) {
            List<Node> tmp = XPathProcessor.evaluate(rpAst, n);
            finalResults.addAll(tmp);
        }

        List<Node> uniqueResults = unique(finalResults);
        return uniqueResults;
    }

    private static List<Node> handleDoubleSlashXQuery(XQueryParser.DoubleSlashXQueryContext doubleSlashCtx,
                                                      Node currentNode,
                                                      Map<String, List<Node>> context) {
        // 1. Evaluate the left XQuery (XQ1)
        List<Node> leftResults = evaluate(doubleSlashCtx.xquery(), currentNode, context);
        List<Node> finalResults = new ArrayList<>();

        // 2. For each node in the leftResults, evaluate //rp
        // create a selfRP
        XQueryParser.RelativePathContext newCtx = new XQueryParser.RelativePathContext(null, -1);
        XQueryParser.SelfRPContext selfRP = new XQueryParser.SelfRPContext(newCtx);
        // create a descendantRP
        XQueryParser.DescendantRPContext descendantRP = new XQueryParser.DescendantRPContext(newCtx);
        descendantRP.addChild(selfRP);
        descendantRP.children.add(doubleSlashCtx.getChild(1));
        descendantRP.children.add(doubleSlashCtx.getChild(2));

        for (Node n : leftResults) {
            List<Node> tmp = XPathProcessor.evaluate(descendantRP, n);
            finalResults.addAll(tmp);
        }

        List<Node> uniqueResults = unique(finalResults);
        return uniqueResults;
    }


    private static List<Node> handleFLWRXQuery(XQueryParser.FlwrXQueryContext flwrCtx, Node currentNode, Map<String, List<Node>> context) {
        List<Node> result = new ArrayList<>();
        XQueryParser.ForClauseContext forCtx = flwrCtx.forClause();
        XQueryParser.LetClauseContext letCtx = flwrCtx.letClause();
        XQueryParser.WhereClauseContext whereCtx = flwrCtx.whereClause();
        XQueryParser.ReturnClauseContext returnCtx = flwrCtx.returnClause();

        List<Map<String, List<Node>>> contextList = new ArrayList<>();
        contextList.add(context);

        // ForClause
        contextList = handleForClause(forCtx, currentNode, contextList);

        // LetClause
        if (flwrCtx.letClause() != null) {
            contextList = handleLetClause(flwrCtx.letClause(), currentNode, contextList);
        }

        // WhereClause
        // Apply whereClause filtering if it exists
        // For each context, evaluate the whereClause
        if (whereCtx != null) {
            contextList = handleWhereClause(whereCtx, currentNode, contextList);
        }
        // ReturnClause
        for (Map<String, List<Node>> ctx: contextList) {
            ParseTree returnQuery = returnCtx.getChild(1);
            List<Node> xqueryRes = evaluate(returnQuery, currentNode, ctx);
            result.addAll(xqueryRes);
        }
        return result;
    }

    // given a foreClauseContext, return a list of contexts (each combination of results of for clauses)
    private static List<Map<String, List<Node>>> handleForClause(XQueryParser.ForClauseContext forClauseCtx, Node currentNode, List<Map<String, List<Node>>> inputContextList ) {
        List<Map<String, List<Node>>> curr = inputContextList;
        int forClauseCount = forClauseCtx.var().size(); // number of for clauses
        for (int i = 0; i < forClauseCount; i++) {
            ParseTree xqueryAst = forClauseCtx.xquery(i);
            String varName = forClauseCtx.var(i).getText();

            List<Map<String, List<Node>>> newContextList = new ArrayList<>();
            // for each previous combinations, {{a1}, {a2}}
            for (Map<String, List<Node>> ctx : curr) {
                // calculate new xquery results
                // {a1}
                List<Node> xqueryRes = evaluate(xqueryAst, currentNode, ctx); // {b1, b2}

                for (Node n : xqueryRes) {
                    Map<String, List<Node>> newCtx = extendContext(ctx, varName, Collections.singletonList(n));
                    newContextList.add(newCtx);
                }
                // {{a1, b1}, {a1, b2}}
            }
            // newContextList: {{a1, b1}, {a1, b2}, {a2, b3}, {a2, b4}}
            curr = newContextList;
        }
        return curr;
    }

    private static List<Map<String, List<Node>>> handleLetClause(
        XQueryParser.LetClauseContext letClauseCtx,
        Node currentNode,
        List<Map<String, List<Node>>> inputContextList
    ) {
        List<Map<String, List<Node>>> res = new ArrayList<>();
        // for each context given by for clause
        for (Map<String, List<Node>> ctx : inputContextList) {

            Map<String, List<Node>> newCtx = new HashMap<>(ctx);

            int letCount = letClauseCtx.var().size();
            for (int i = 0; i < letCount; i++) {
                String varName = letClauseCtx.var(i).getText();
                ParseTree xqueryAst = letClauseCtx.xquery(i);

                List<Node> xqResult = evaluate(xqueryAst, currentNode, newCtx);
                newCtx.put(varName, xqResult);
            }

            res.add(newCtx);
        }
        return res;
    }
    

    private static boolean evaluateCondition(ParseTree condition, Node currentNode, Map<String, List<Node>> context) {
        if (condition instanceof XQueryParser.EqConditionContext) {
            return handleEqCondition(condition, currentNode, context);
        }
        if (condition instanceof XQueryParser.IsConditionContext) {
            return handleIsCondition(condition, currentNode, context);
        }
        if (condition instanceof XQueryParser.NotConditionContext) {
            return handleNotCondition(condition, currentNode, context);
        }
        if (condition instanceof XQueryParser.OrConditionContext) {
            return handleOrCondition(condition, currentNode, context);
        }
        if (condition instanceof XQueryParser.AndConditionContext) {
            return handleAndCondition(condition, currentNode, context);
        }
        if (condition instanceof XQueryParser.ParenthesizedConditionContext) {
            return handleParenthesizedCondition(condition, currentNode, context);
        }
        if (condition instanceof XQueryParser.EmptyConditionContext) {
            return handleEmptyCondition(condition, currentNode, context);
        }
        if (condition instanceof XQueryParser.SatisfyConditionContext) {
            return handleSatisfyCondition((XQueryParser.SatisfyConditionContext)condition, currentNode, context);
        }
        return false;
    }

    // Implementation of satisfyCondition handling:
    private static boolean handleSatisfyCondition(XQueryParser.SatisfyConditionContext condition, Node currentNode, Map<String, List<Node>> context) {
        return satisfyHelper(condition, 0, currentNode, context);
    }

    private static boolean satisfyHelper(XQueryParser.SatisfyConditionContext condition, int curIndex, Node currentNode, Map<String, List<Node>> context) {
        // Base case: all variable bindings have been processed.
        if (condition.var().size() == curIndex) {
            // Evaluate the condition (queryCondition) in the current context.
            boolean condResult = evaluateCondition(condition.queryCondition(), currentNode, context);
            return condResult;
        }
        // Process the current variable binding.
        String var = condition.var(curIndex).getText();
        ParseTree xqueryAst = condition.xquery(curIndex);
        List<Node> xqResults = evaluate(xqueryAst, currentNode, context);

        // For each result, extend the context and recursively process the next variable.
        for (Node n : xqResults) {
            Map<String, List<Node>> newContext = new HashMap<>(context);
            newContext.put(var, Collections.singletonList(n));
            boolean res = satisfyHelper(condition, curIndex + 1, currentNode, newContext);
            if (res) {
                return true;
            }
        }

        // If no variable binding leads to a satisfied condition, return null.
        return false;
    }

    private static boolean handleEmptyCondition(ParseTree condition, Node currentNode, Map<String, List<Node>> context){
        List<Node> xqResults = evaluate(condition.getChild(2), currentNode, context);
        return xqResults.isEmpty();
    }

    private static boolean handleEqCondition(ParseTree condition, Node currentNode, Map<String, List<Node>> context){
        // EqCondition:
        // ∃x ∈ [[X Q1 ]]X (C ) ∃y ∈ [[X Q2 ]]X (C ) x eq y
        List<Node> xqResults0 = evaluate(condition.getChild(0), currentNode, context);
        List<Node> xqResults1 = evaluate(condition.getChild(2), currentNode, context);
        for (Node node1 : xqResults0) {
            for (Node node2 : xqResults1) {
                if (node1.isEqualNode(node2)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean handleIsCondition(ParseTree condition, Node currentNode, Map<String, List<Node>> context){
        List<Node> xqResults0 = evaluate(condition.getChild(0), currentNode, context);
        List<Node> xqResults1 = evaluate(condition.getChild(2), currentNode, context);
        for (Node node1 : xqResults0) {
            for (Node node2 : xqResults1) {
                if (node1.isSameNode(node2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean handleNotCondition(ParseTree condition, Node currentNode, Map<String, List<Node>> context){
        return !evaluateCondition(condition.getChild(1), currentNode, context);
    }
    private static boolean handleParenthesizedCondition(ParseTree condition, Node currentNode, Map<String, List<Node>> context){
        return evaluateCondition(condition.getChild(1), currentNode, context);
    }
    private static boolean handleAndCondition(ParseTree condition, Node currentNode, Map<String, List<Node>> context){
        return evaluateCondition(condition.getChild(0), currentNode, context) && evaluateCondition(condition.getChild(2), currentNode, context);
    }
    private static boolean handleOrCondition(ParseTree condition, Node currentNode, Map<String, List<Node>> context){
        return evaluateCondition(condition.getChild(0), currentNode, context) || evaluateCondition(condition.getChild(2), currentNode, context);
    }

    private static List<Map<String, List<Node>>> handleWhereClause(
        XQueryParser.WhereClauseContext whereClauseCtx,
        Node currentNode,
        List<Map<String, List<Node>>> inputContextList) {

        List<Map<String, List<Node>>> filteredContextList = new ArrayList<>();

        // Get the where clause condition (XQuery expression that must evaluate to true)
        ParseTree condition = whereClauseCtx.getChild(1);

        // For each context given by forClause, check the whereClause, if true, keep the context
        for (Map<String, List<Node>> ctx : inputContextList) {
            boolean conditionResult = evaluateCondition(condition, currentNode, ctx);

            if (conditionResult) {
                filteredContextList.add(ctx);
            }
        }

        return filteredContextList;
    }


    private static List<Node> handleVarXQuery(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        String varName = ast.getText();
        return context.getOrDefault(varName, Collections.emptyList());
    }

    private static List<Node> handleBraceXQuery(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        ParseTree insideXQ = ast.getChild(1);
        List<Node> resultNodes = evaluate(insideXQ, currentNode, context);
        return resultNodes;
    }

    private static List<Node> handleCommaXQuery(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        ParseTree leftXQ = ast.getChild(0);
        ParseTree rightXQ = ast.getChild(2);
        List<Node> leftRes = evaluate(leftXQ, currentNode, context);
        List<Node> rightRes = evaluate(rightXQ, currentNode, context);
        List<Node> result = new ArrayList<>();
        result.addAll(leftRes);
        result.addAll(rightRes);
        return result;
    }

    private static List<Node> handleTagXQuery(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        List<Node> result = new ArrayList<>();
        String tagName = ast.getChild(0).getChild(1).getText();
        ParseTree insideXQ = ast.getChild(2);
        List<Node> insideNodes = evaluate(insideXQ, currentNode, context);
        result.add(makeElement(tagName, insideNodes));
        return result;
    }

    private static List<Node> handleApXQuery(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        ParseTree rpChild = ast.getChild(0);
        return XPathProcessor.evaluate(rpChild, currentNode);
    }

    private static List<Node> unique(List<Node> nodes) {
        List<Node> uniqueResults = new ArrayList<>(new LinkedHashSet<>(nodes));
        return uniqueResults;
    }

}

