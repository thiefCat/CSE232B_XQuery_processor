grammar XPath;

@header {
    package main.antlr;
}

absolutePath
    : doc '/' relativePath     # childAP
    | doc '//' relativePath    # descendantAP
    ;

relativePath
    : tagName       # tagRP
    | '*'           # allChildrenRP
    | '.'           # selfRP
    | '..'          # parentRP
    | 'text()'      # textRP
    | '@' attrName  # attributeRP
    | '(' relativePath  ')'    # bracketRP
    | relativePath  '/' relativePath      # childrenRP
    | relativePath  '//' relativePath     # descendantRP
    | relativePath  '[' f ']'  # filterRP
    | relativePath  ',' relativePath      # commaRP
    ;

f   : relativePath         # rpFilter
    | relativePath  EQ relativePath   # eqFilter
    | relativePath  IS relativePath   # isFilter
    | relativePath  EQ STRING # stringFilter
    | '(' f ')' # bracketFilter
    | f 'and' f # andFilter
    | f 'or' f  # orFilter
    | 'not' f   # notFilter
    ;

doc : 'doc(' FILENAME ')'
    | 'document(' FILENAME ')'
    ;
tagName : ID;
attrName : ID;

EQ  : '=' | 'eq';
IS  : '==' | 'is';
ID  : [a-zA-Z0-9_-]+ ;

FILENAME    : '"' [a-zA-Z0-9._\\-]+[.][a-zA-Z0-9._]+ '"';
WHITESPACE  : [ \t\r\n]+ -> skip;

STRING
    : '"' (ESCAPE | ~["\\])* '"'
    | '\'' (ESCAPE | ~['\\])* '\''
    ;
ESCAPE
    : '\\' (['"\\])
    ;
