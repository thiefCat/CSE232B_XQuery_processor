# XPath Evaluator


## To test the program, follow the following:
**The input xml file should be put under src/main/resources directory (j_caesar.xml).**

1. Replace one_xpath_query.txt with a txt file that contains only one line of XPath query.
2. Replace output_path.xml with the desired output file path.

```
java -jar target/CSE232B_XPathEngine-jar-with-dependencies.jar one_xpath_query.txt output_path.xml
```
e.g.
```
java -jar target/CSE232B_XPathEngine-jar-with-dependencies.jar "src/main/resources/XPathQuery0.txt" "src/output/output0.xml"
```

## Appendix:

### Generate jar:
To generate the jar package, make sure Antlr4 is downloaded in the system.

Commands for using antlr4 to auto generate expression parser code:
```
./generate.sh
```

To generate jar, run:
```
mvn clean package
```
The jar package should appear under 'target/'


### Run the program manually
1. Make sure Antlr is installed
2. Generate expression parser code
```
./generate.sh
```
3. Run src/main/java/Main.java with two parameters ("one_xpath_query.txt" and "output_path.xml")







