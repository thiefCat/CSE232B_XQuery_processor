rm -rf classes
rm -rf data/result
# find . -name "*.class" -type f -delete
cd src/main/antlr
rm -f *.tokens *.interp XPath*.java XQuery*.java
cd ../../..