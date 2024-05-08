# PLCD_Assignment

       implement a program to simulate a lexical analyzer and a parser to the given grammar.


This project implements a lexical analyzer and parser based on a specified grammar. The program evaluates input strings against grammar productions, generates a parse tree, and manages a symbol table to store token information.

Grammar

The grammar provided for this project is:

E → TE´

E´→ +TE´|Ɛ

T → FT´

T´→ *FT´|Ɛ

F → (E)|id

id → 0|1|2|3|4|5|6|7|8|9|a…z|A…Z

                        



