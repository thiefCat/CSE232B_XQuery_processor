cd src/main/java/milestone1
antlr4 -visitor -o autogen/ExpressionParser XPath.g4
echo "ANTLR files generated successfully!"


## to compile Main.java: do it under 232B_PA1/CSE232B_XQuery_processor
## Compile the Java program
#mvn compile
#mvn exec:java -Dexec.mainClass="milestone1.Main" -Dexec.args="src/main/resources/XPathQuery0.txt src/output/milestone1/output0.xml"
#mvn exec:java -Dexec.mainClass="milestone1.Main" -Dexec.args="src/main/resources/XPathQuery1.txt src/output/milestone1/output1.xml"
#mvn exec:java -Dexec.mainClass="milestone1.Main" -Dexec.args="src/main/resources/XPathQuery2.txt src/output/milestone1/output2.xml"
#mvn exec:java -Dexec.mainClass="milestone1.Main" -Dexec.args="src/main/resources/XPathQuery3.txt src/output/milestone1/output3.xml"
#mvn exec:java -Dexec.mainClass="milestone1.Main" -Dexec.args="src/main/resources/XPathQuery4.txt src/output/milestone1/output4.xml"
