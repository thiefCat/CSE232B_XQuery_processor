package milestone1.XPathEvaluator;

import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /* TODO:
         * Call evaluate
         * Call transform
         * Call save_xml
         */
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    /* TODO:
     * Construct AST tree,
     * Call visit functions on the tree to evaluate
     */
    public static List<Node> evaluate(String xPathQuery) {
        return null;
    }

    /* TODO:
     * Used to generate the final result in xml
     */
    public static Document transform(List<Node> result) throws Exception{
        return null;
    }

    /* TODO:
     * Save the Document result to a xml file
     */
    public static void save_xml(Document result){
        return;
    }

}
