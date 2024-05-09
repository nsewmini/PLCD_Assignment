package plcd_assignment;
 
import java.util.*;
// Waypoint class that reprsents  Waypoins of  parsetree
 
class Waypoint {
 
    String label;
    List<Waypoint> children;
 
    Waypoint(String label) {
        this.label = label;
        children = new ArrayList<>();
    }
 
    void addChild(Waypoint child) {
        children.add(child);
    }
 
    List<Waypoint> getChildren() {
        return children;
    }
}
// create constrctor symbol
 
class Symbol {
 
    String lexeme;
    String symbolType;
 
    public Symbol(String lexeme, String symbolType) {
        this.lexeme = lexeme;// initializ lxeme
        this.symbolType = symbolType; // initializ symboltype
    }
}
 
public class Parser {
 
    private static String input;
    private static int index;
    private static Waypoint root;
    private static Map<String, String> symbolMap;
    private static List<Symbol> symbolTable;
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input string:");
        input = scanner.nextLine();
 
        // create  map from symbols to their types
        symbolMap = new HashMap<>();
        symbolMap.put("(", "LEFT_PAREN");
        symbolMap.put(")", "RIGHT_PAREN");
        symbolMap.put("+", "ADD_OP");
        symbolMap.put("*", "MULT_OP");
        symbolMap.put("/", "DIV_OP");
        symbolMap.put("-", "SUB_OP");
        symbolMap.put("EPSILON", "EPSILON");
        symbolMap.put("id", "IDENTIFIER");
        symbolMap.put("NUMBER", "NUMBER");
 
        // Set up  symboltable first
        symbolTable = new ArrayList<>();
 
        // Set index and root of parsetree
        index = 0;
        root = new Waypoint("E");
 
        // analyze  input expression.
        if (ExpressionParserE(root)) {
            if (index == input.length()) {
                System.out.println("Input string is accepted.");// display result accepted 
            } else {
                System.out.println("Input string is not fully consumed. Parsing stopped.");//display result Parsing stopped 
            }
        } else {
            System.out.println("Input string is not accepted.");//display result not accepted
        }
 
        // setup lists to store lexemes and symboltypes
        List<String> lexemes = new ArrayList<>();
        List<String> symbolTypes = new ArrayList<>();
 
         // loop through symbol table to identify lxemes and symboltypes
        for (Symbol symbol : symbolTable) {
            // add lexeme to the list of lxemes
            lexemes.add(symbol.lexeme);
            // add symbol type to the list of symboltypes
            symbolTypes.add(symbol.symbolType);
        }
     

        System.out.println("Lexemes: " + lexemes);// print lexemes 
        System.out.println("Symbols: " + symbolTypes);// print symboltypes

        // print symboltable
        System.out.println("\nSymbol Table:");
        for (Symbol symbol : symbolTable) {
            System.out.println("Lexeme: " + symbol.lexeme + ", Symbol Type: " + symbol.symbolType);
        }

        // print parsetree
        System.out.println("\nParse Tree:");
        displayParseTree(root, 0);
    }

    // display gramar rules 
    private static boolean ExpressionParserE(Waypoint x) {
        Waypoint child = new Waypoint("T");
        x.addChild(child);
        if (ExpressionParserT(child)) {
            return ExpressionParserEPrime(x);
        }
        return false;
    }

    private static boolean ExpressionParserEPrime(Waypoint x) {
   // if there are othr terms to parse and if the caracter to be enter is  '+' or  '+', test them
    if (index < input.length() && (input.charAt(index) == '+' || input.charAt(index) == '-')) {
        // to find symbol and it typeneed a symbolmap.
        String symbol = Character.toString(input.charAt(index));
        String symbolType = symbolMap.get(symbol);
        // putsymbol in table of symbols
        symbolTable.add(new Symbol(symbol, symbolType));
       // make an opeator waypoint and add it as the child of the waypoint.
        Waypoint child = new Waypoint(symbolMap.get(symbol));
        x.addChild(child);
        index++; // change to the nextchracter in the inputstring
        // Create a new waypoint for next term in the expresion
        Waypoint newChild = new Waypoint("T");
        x.addChild(newChild);
      
// look at the underlying phrase ofexpression.
        if (ExpressionParserT(newChild)) {
         // if it is acceptable to interpret the next trme, recursivelyParse the remainder of E'.
            return ExpressionParserEPrime(x);
        }
        // return false if followig term's parsing is incorect
        return false;
    }
    // return true to show that E's paring is effective if there are no more terms to parse.
    return true;
}

    private static boolean ExpressionParserT(Waypoint x) {
    //make a waypoint for element and add it to list of current waypoints aschild.
    Waypoint child = new Waypoint("F");
    x.addChild(child);
    // Parse the element
    if (ExpressionParserF(child)) {
        // if the element's parsing is successful, use T' to parse the last part of the term.
        return ExpressionParserTPrime(x);
    }
    // return false if the element's processing is unsuccessful.
    return false;
}

    private static boolean ExpressionParserTPrime(Waypoint x) {
    // check if there are extra variables to consider and if the current character is a '*' or '/'
    if (index < input.length() && (input.charAt(index) == '*' || input.charAt(index) == '/')) {
        // find the symbol and its type from the symbolmap
        String symbol = Character.toString(input.charAt(index));
        String symbolType = symbolMap.get(symbol);
        // added the symbol to the symbol table
        symbolTable.add(new Symbol(symbol, symbolType));
        // set a waypoint for the operator and added it as a child of the currently waypoint
        Waypoint child = new Waypoint(symbolMap.get(symbol));
        x.addChild(child);
        index++; // change to the next character in the input string
        // create a new waypoint for the next factor 
        Waypoint newChild = new Waypoint("F");
        x.addChild(newChild);
        // parse the next factor in theexpresion
        if (ExpressionParserF(newChild)) {
            // if procesing of the next component is successful, continusly parse rest of T'
            return ExpressionParserTPrime(x);
        }
        // return false ifnext factor procesing is unsucessful.
        return false;
    }
