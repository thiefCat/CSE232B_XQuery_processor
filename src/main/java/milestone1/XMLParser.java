package milestone1;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class XMLParser {
    /*
      Loads an XML file into a DOM Tree
     */
    public static Document loadXML(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        // Parse XML into DOM
        InputStream inputStream = new FileInputStream(file);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document originalDoc = builder.parse(inputStream);
        originalDoc.getDocumentElement().normalize();

        // Create a new Document with a dummy root
        Document newDoc = builder.newDocument();
        Element dummyRoot = newDoc.createElement("dummyRoot");
        newDoc.appendChild(dummyRoot);

        // Import and append the original root as a child of the dummy root
        Node importedNode = newDoc.importNode(originalDoc.getDocumentElement(), true);
        dummyRoot.appendChild(importedNode);

        return newDoc;
    }

    public static void saveXML(Document doc, String outputPath) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
//        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(outputPath));
        transformer.transform(source, result);
    }
}
