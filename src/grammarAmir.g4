grammar grammarAmir;

@header {
    package parser;
}

// Parser rules

program: (definition NEWLINE)* (statement NEWLINE)* EOF;

statement: assignment
         | ifStatement
         | whileStatement
         | printStatement
         ;

definition: classDeclaration;

assignment
    : ID '=' expression
    | SELF_ID '=' expression
    | expression '.' ID '=' expression;

elifClause
    : 'elif' expression ':' statementBlock
    ;

elseClause
    : 'else' ':' statementBlock
    ;

ifStatement
    : 'if' expression ':' statementBlock (elifClause)* (elseClause)?
    ;

whileStatement: 'while' expression ':' statementBlock;

printStatement: 'print' expression;

expression
    : 'not' expression                        // Logical NOT (unary) with correct placement
    | expression 'and' expression             // Logical expressions with clear precedence
    | expression 'or' expression              // Logical expressions with clear precedence
    | expression OPERATOR expression          // Arithmetic expressions
    | expression COMP_OP expression           // Comparison expressions
    | expression '.' ID '(' arguments? ')'    // Object method call
    | expression '.' ID                       // Object attribute access
    | 'new' ID '(' arguments? ')'             // Class instantiation
    | atom                                    // Basic expressions
    ;

classDeclaration: 'class' ID classBody;

classBody: ':' (NEWLINE assignment)* (NEWLINE constructorDeclaration)? (NEWLINE classMethodDeclaration)*;

constructorDeclaration: 'def' '__init__' '(' 'self' (',' parameters)? ')' ':' (NEWLINE assignment)+; //at least one parameter in a class is necessary

classMethodDeclaration: 'def' ID '(' 'self' (',' parameters)? ')' ':' statementBlock returnStatement;

returnStatement
    : 'return' expression?;

parameters: ID (',' ID)*;

arguments: expression (',' expression)*;

statementBlock: NEWLINE (statement NEWLINE)*;

atom
    : 'True'
    | 'False'
    | 'None'
    | 'self'
    | SELF_ID
    | ID
    | INT
    | STRING
    | '(' expression ')'
    ;

// Lexer rules

ID: [a-zA-Z_] [a-zA-Z_0-9]*;

SELF_ID : 'self.' [a-zA-Z_] [a-zA-Z_0-9]*;

INT: [0-9]+;

STRING: '"' .*? '"';

OPERATOR: '+' | '-' | '*' | '/';

COMP_OP: '==' | '!=' | '<' | '>' | '<=' | '>=';

NEWLINE: '\r'? '\n';

WS: [ \t]+ -> skip; // Ignore regular whitespace

// Still need to work on the indentation rule in the ANTLR grammar, don't forget