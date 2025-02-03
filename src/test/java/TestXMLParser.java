import milestone1.XMLParser;
import org.w3c.dom.Document;

public class TestXMLParser {
    public static void main(String[] args) throws Exception {
        String xmlFileName = "src/test/resources/j_caesar.xml";
        Document domTree = XMLParser.loadXML(xmlFileName);
        String outputPath = "src/output.xml";
        XMLParser.saveXML(domTree, outputPath);
    }
}
