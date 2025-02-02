import milestone1.autogen.ExpressionParser.XPathLexer;
import milestone1.autogen.ExpressionParser.XPathParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class simpleTest {
    public static void main(String[] args) throws Exception {
        String fname = args[0];
        XPathLexer lexer = new XPathLexer(new ANTLRFileStream(fname));
        XPathParser parser = new XPathParser(new CommonTokenStream(lexer));
        System.out.println(fname);
//        ParseTree tree = parser.eval();
//        System.out.println(compute(tree));
    }
}
