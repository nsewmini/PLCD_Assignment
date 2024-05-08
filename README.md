# PLCD_Assignment

## Implementation of Lexical Analyzer and Parser

{This project implements a lexical analyzer and parser based on a specified grammar. The program evaluates input strings against grammar productions, generates a parse tree, and manages a symbol table to store token information.}

This Java program simulates a lexical analyzer and a parser based on a specified grammar. The program is designed to:

Tokenize input strings according to defined grammar rules.
Construct a symbol table to store token information.
Generate a top-down parse tree based on the input string.
Determine if the input string can be accepted by the defined grammar.

### Grammar

The grammar provided for this project is:

E → TE´

E´→ +TE´|Ɛ

T → FT´

T´→ *FT´|Ɛ

F → (E)|id

id → 0|1|2|3|4|5|6|7|8|9|a…z|A…Z

#Program Features

Lexical Analysis:
        Break down input strings into lexemes and map them to predefined token types using a symbol table.
 Parsing:
        Construct a top-down parse tree based on the grammar rules.
        Determine if the input string is syntactically valid according to the grammar.

#Implemented Components

The program consists of:

 Symbol Table: Stores lexemes along with their corresponding token types.
 Parse Tree: Utilizes a hierarchical structure to represent the parsing process.
 Main Parser Logic: Implements recursive descent parsing for the specified grammar.


        

                        



