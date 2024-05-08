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
