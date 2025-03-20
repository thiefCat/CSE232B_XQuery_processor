package main;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.*;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class XMLParser {
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

    public static void saveXML(Document document, String outputPath) throws Exception {
        Path outputFilePath = Paths.get(outputPath);
        Path parentDir = outputFilePath.getParent();

        if (parentDir != null && !Files.exists(parentDir)) {
            Files.createDirectories(parentDir); // Create the parent directory if it does not exist
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        File outputFile = new File(outputPath);

        // Write the entire XML document to the file
        try (FileWriter fileWriter = new FileWriter(outputFile);
             StringWriter writer = new StringWriter()) {

            transformer.transform(new DOMSource(document), new StreamResult(writer));

            // Save to file
            fileWriter.write(writer.toString());
        }
    }
}
