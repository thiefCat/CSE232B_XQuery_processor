import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.*;
import java.util.*;
import antlr.XQueryParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XQueryProcessor {
    static Document tmpDoc = null;

    public static Document compute(Document document, ParseTree ast) throws Exception {

        if (ast instanceof XQueryParser.ApXQueryContext) {
            // a Xpath
            return XPathProcessor.compute(document, ast.getChild(0));
        } else {
            // a Xquery
            Map<String, List<Node>> emptyContext = new HashMap<>();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            tmpDoc = builder.newDocument();

            List<Node> resultNodes = evaluate(ast, document, emptyContext);

            if (resultNodes == null || resultNodes.isEmpty()) {
                return tmpDoc;
            }

            Node root = resultNodes.get(0);
            Node importedRoot = tmpDoc.importNode(root, true);
            tmpDoc.appendChild(importedRoot);

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

        if (ast instanceof XQueryParser.TagXQueryContext) {
            return handleTagXQuery(ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.ApXQueryContext) {
            return handleApXQuery(ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.VarXQueryContext) {
            return handleVarXQuery(ast, currentNode, context);
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

    private static Node makeText(String text){
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

    private static List<Node> handleFLWRXQuery(XQueryParser.FlwrXQueryContext flwrCtx, Node currentNode, Map<String, List<Node>> context) {
        List<Node> result = new ArrayList<>();
        XQueryParser.ForClauseContext forCtx = flwrCtx.forClause();
        XQueryParser.LetClauseContext letCtx = flwrCtx.letClause();
        XQueryParser.WhereClauseContext whereCtx = flwrCtx.whereClause();
        XQueryParser.ReturnClauseContext returnCtx = flwrCtx.returnClause();
        List<Map<String, List<Node>>> contextList = new ArrayList<>();
        contextList.add(context);
        contextList = handleForClause(forCtx, currentNode, contextList);
        for (Map<String, List<Node>> ctx: contextList) {
            ParseTree returnQuery = returnCtx.getChild(1);
            List<Node> xqueryRes = evaluate(returnQuery, currentNode, ctx);
            result.addAll(xqueryRes);
        }
        return result;
    }

    // given a foreClauseContext, return a list of contexts (each combination of results of for clauses)
    // TO DO: assumption that given input context is empty
    private static List<Map<String, List<Node>>> handleForClause(XQueryParser.ForClauseContext forClauseCtx, Node currentNode, List<Map<String, List<Node>>> inputContextList ) {
        List<Map<String, List<Node>>> curr = inputContextList;
        int forClauseCount = forClauseCtx.var().size(); // number of for clauses
        for (int i = 0; i < forClauseCount; i++) {
            ParseTree varNode = forClauseCtx.var(i);
            ParseTree xqueryAst = forClauseCtx.xquery(i);
            String varName = varNode.getText();

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

    private static List<Node> handleVarXQuery(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        String varName = ast.getText();
        return context.getOrDefault(varName, Collections.emptyList());
    }

    private static List<Node> handleBraceXQuery(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        ParseTree insideXQ = ast.getChild(1);
        List<Node> resultNodes = evaluate(insideXQ, currentNode, context);
        return resultNodes;
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

}

