# XPath Evaluator

To run the program, follow the following:



```
mvn clean package
```

```
java -jar target/CSE232B_XPathEngine-jar-with-dependencies.jar "one_xpath_query.txt" "output_path.xml"
```





Commands for using antlr4 to auto generate expression parser code:

```
cd src/main/java/milestone1                                                                       
antlr4 -visitor -o autogen/ExpressionParser XPath.g4 
```




