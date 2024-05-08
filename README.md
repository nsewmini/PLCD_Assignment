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

### Program Features

Lexical Analysis:

        Break down input strings into lexemes and map them to predefined token types using a symbol table.
        
 Parsing:
 
        Construct a top-down parse tree based on the grammar rules.
        Determine if the input string is syntactically valid according to the grammar.

### Implemented Components

The program consists of:

     Symbol Table: Stores lexemes along with their corresponding token types.
     Parse Tree: Utilizes a hierarchical structure to represent the parsing process.
     Main Parser Logic: Implements recursive descent parsing for the specified grammar.

### Usage
Running the Program:

To run your program using NetBeans, follow these steps:

Open NetBeans
    Launch the NetBeans IDE on your computer.

2. Open the Project

    Go to File > Open Project...
    Navigate to the directory where your Java project is located.
    Select the project folder and click Open.

3. Build the Project

    In NetBeans, locate your project in the Projects pane.
    Right-click on the project name and choose Build.
    This will compile your Java files and build the project.

4. Run the Main Class

    After the project is built successfully, locate your main Java class (Parser.java) in the project structure.
    Right-click on Parser.java and choose Run File.

5. Provide Input

    NetBeans will open a console or output window where your program will prompt you to enter an input string.
    Enter the desired input string and press Enter.

6. View Output

    The program will process the input string based on the specified grammar rules.
    Output will be displayed in the NetBeans console, showing lexemes, symbol types, symbol table entries, and the parse tree.

7. Analyze Results

    Review the program's output to see the lexical analysis, symbol table contents, and parse tree structure based on the input string.
    Ensure to check for any error messages or exceptions in the console output if applicable.


### Sample Input/Output

![image](https://github.com/nsewmini/PLCD_Assignment/assets/96427674/503ce3e8-fb1c-428a-9b48-7b841baba18b)

![image](https://github.com/nsewmini/PLCD_Assignment/assets/96427674/28c73fac-3686-4c4d-abed-13d209413da8)

![image](https://github.com/nsewmini/PLCD_Assignment/assets/96427674/6a1d24af-78ea-4bca-92a7-2d25f5fb8cb0)

![image](https://github.com/nsewmini/PLCD_Assignment/assets/96427674/e962ee60-9b85-4a94-b82f-cd099f6fc1a5)



Additional Notes

    Ensure that your NetBeans IDE is properly configured to compile and run Java projects.
    Make sure your project dependencies and settings are correctly set up within NetBeans.
    If encountering any issues during compilation or execution, refer to NetBeans documentation or seek assistance for troubleshooting.

### Contributing
Authors

W.Navodya Sewmini

D.S Sathsarani

MLAWA Karunarathna 


.....Lastly, thank you for exploring this project! If you have any questions, feedback, or suggestions, please feel free to reach out. Your input is greatly appreciated!.......                 



