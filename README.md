# XPath Evaluator

Commands for using antlr4 to auto generate expression parser code:

```
cd src/main/java/milestone1                                                                       
antlr4 -visitor -o autogen/ExpressionParser XPath.g4 
```





## To do

- [ ] Write a g4 grammar file, which defines a valid XPath expression
- [ ] Define the architecture
- [ ] Write tests

doc("j_caesar.xml")//SCENE[SPEECH/SPEAKER/text() = "CAESAR"]

● Find all persons in the play:
doc("j_caesar.xml")//PERSONA
● Find the scenes in which CAESAR speaks
doc("j_caesar.xml")//SCENE[SPEECH/SPEAKER/text() = "CAESAR"]
● Find the acts containing some scene in which both CAESAR and BRUTUS speak
doc("j_caesar.xml")//ACT[SCENE [SPEECH/SPEAKER/text() = "CAESAR" and
SPEECH/SPEAKER/text() = "BRUTUS"]]
● Same as previous, but different syntax
doc("j_caesar.xml")//ACT[SCENE [SPEECH/SPEAKER/text() = "CAESAR"]
[SPEECH/SPEAKER/text() = “BRUTUS”]]
● Find the acts in which CAESAR no longer appears
doc("j_caesar.xml")//ACT[not .//SPEAKER/text() = "CAESAR"]