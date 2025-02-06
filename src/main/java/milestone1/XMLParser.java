package milestone1;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.*;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class XMLParser {
    /*
      Loads an XML file into a DOM Tree

          dummy root
              |
             root

     */


    public static Document loadXML(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        // Parse XML into DOM
        InputStream inputStream = new FileInputStream(file);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document originalDoc = builder.parse(inputStream);
        originalDoc.getDocumentElement().normalize();

        return originalDoc;
    }

    public static void saveXML(List<Node> resultNodes, String outputPath) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        File outputFile = new File(outputPath);
        StringWriter writer = new StringWriter();
        for (Node node : resultNodes) {
            transformer.transform(new DOMSource(node), new StreamResult(writer));
        }
        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            fileWriter.write(writer.toString());
        }
    }
}
