grammar XQuery;
import XPath;

xquery : var                                               # varXQuery
   | STRING                                                # scXQuery
   | absolutePath                                          # apXQuery
   | '(' xquery ')'                                        # braceXQuery
   | xquery ',' xquery                                     # commaXQuery
   | xquery '/' relativePath                               # singleSlashXQuery
   | xquery '//' relativePath                              # doubleSlashXQuery
   | beginTag '{' xquery '}' endTag                        # tagXQuery
   | forClause letClause? whereClause? returnClause        # flwrXQuery
   | letClause xquery                                      # letXQuery
   ;

forClause : 'for' var 'in' xquery (',' var 'in' xquery)* ;
letClause : 'let' var ':=' xquery (',' var ':=' xquery)* ;
whereClause : 'where' queryCondition ;
returnClause : 'return' xquery ;

queryCondition : xquery EQ xquery                                                  # eqCondition
     | xquery IS xquery                                                            # isCondition
     | 'empty' '(' xquery ')'                                                      # emptyCondition
     | 'some' var 'in' xquery (',' var 'in' xquery)* 'satisfies' queryCondition    # satisfyCondition
     | '(' queryCondition ')'                                                      # parenthesizedCondition
     | queryCondition 'and' queryCondition                                         # andCondition
     | queryCondition 'or' queryCondition                                          # orCondition
     | 'not' queryCondition                                                        # notCondition
     ;

beginTag: '<' tagName '>';
endTag: '<' '/' tagName '>';
var: '$' ID;