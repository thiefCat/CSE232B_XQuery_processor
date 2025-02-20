
## Generate Java files using Antlr:
java -jar lib/antlr-4.13.2-complete.jar -Dlanguage=Java -visitor -no-listener -o ./ main/antlr/XPath.g4
java -jar lib/antlr-4.13.2-complete.jar -Dlanguage=Java -visitor -no-listener -o ./ main/antlr/XQuery.g4


## Run the code:
1. Include lib/antlr-4.13.2-complete.jar in project dependencies.
2. Run the main function with the following three parameters: 
resource xml file, recourse single-line XPath txt file, output file

For example,
resources/j_caesar.xml resources/q1.txt output.xml  
```
java -cp lib/* main.Main resources/j_caesar.xml resources/q1.txt output.xml 
```
