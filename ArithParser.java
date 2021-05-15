/**
 * A Parser for our Arith language
 * (a simple language of arithmetic expressions).
 * 
 * <code>
 * EXPRESSION   ::= [ "+" | "-" ] TERM { ( "+" | "-" ) TERM }
 * TERM         ::= FACTOR { ( "*" | "/" ) FACTOR }
 * FACTOR       ::= Literal | 
 *                  Identifier| 
 *                  "(" EXPRESSION ")"
 * </code>
 */
public final class ArithParser implements Parser {

    private LexicalAnalyzer lexer;
    
    
    /**
     * Parse a program in the Arith language.
     * @param sourceCode The source code of the program in the Arith language
     * @return an AST of the program
     */
    public Node parse(final String sourceCode) {
        this.lexer = new LexicalAnalyzer(sourceCode);
        // fetch first token
        lexer.fetchNextToken();
        // now parse the EXPRESSION
        return parseExpression();
    }
    
    /**
     * Parse an expression.
     * This assumes the lexer already points to the first token of this expression.
     * 
     * <p>EBNF:
     * <code>
     * EXPRESSION ::= [ "+" | "-" ] TERM { ( "+" | "-" ) TERM }
     * </code>
     * 
     * @return a Node representing the expression
     */
    private Node parseExpression() {
        
        Node currentT;
        
        if (lexer.getCurrentToken().getType() == TokenType.MINUS) {
            lexer.fetchNextToken();
            currentT = new Negation(parseTerm());
            if (lexer.getCurrentToken().getType() == TokenType.END_OF_FILE) {
                return currentT;
            }
            
        } else if (lexer.getCurrentToken().getType() == TokenType.PLUS) {
            lexer.fetchNextToken();
            currentT = parseTerm();
            if (lexer.getCurrentToken().getType() == TokenType.END_OF_FILE) {
                return currentT;
            }
            
        } else {
            currentT = parseTerm();
        }

        if (lexer.getCurrentToken().getType() != TokenType.END_OF_FILE) {
            
            if (lexer.getCurrentToken().getType() == TokenType.PLUS || lexer.getCurrentToken().getType() == TokenType.MINUS) {
                if (lexer.getCurrentToken().getType() == TokenType.PLUS) {
                    lexer.fetchNextToken();
                    return new Addition(currentT, parseExpression());
                } 

                if ((lexer.getCurrentToken().getType() == TokenType.MINUS)){
                    lexer.fetchNextToken();
                    return new Subtraction(currentT, parseExpression());
                }
            }
        }
        
        return currentT;
    }

    /**
     * Parse a term.
     * This assumes the lexer already points to the first token of this term.
     * 
     * <p>EBNF:
     * <code>
     * TERM ::= FACTOR { ( "*" | "/" ) FACTOR }
     * </code>
     * 
     * @return a Node representing the term
     */
    private Node parseTerm() {

        final Node first = parseFactor();

        if (lexer.getCurrentToken().getType() == TokenType.SLASH || lexer.getCurrentToken().getType() == TokenType.STAR) {
            if (lexer.getCurrentToken().getType() == TokenType.STAR) {
                lexer.fetchNextToken();
                return new Multiplication(first, parseTerm());
            } 

            if ((lexer.getCurrentToken().getType() == TokenType.SLASH)){
                lexer.fetchNextToken();
                return new Division(first,  parseTerm());
            }
        }
        return first;
    }

    /**
     * Parse a factor.
     * This assumes the lexer already points to the first token of this factor.
     * 
     * <p>EBNF:
     * <code>
     * FACTOR ::=  
     *          Literal | 
     *          Identifier | 
     *          "(" EXPRESSION ")"
     * </code>
     * 
     * @return a Node representing the factor
     */
    private Node parseFactor() {
        Node factor;
        
        if (lexer.getCurrentToken().getType() == TokenType.LITERAL) {
            factor = new Literal(Integer.parseInt(lexer.getCurrentToken().getText()));
        }

        else if (lexer.getCurrentToken().getType() == TokenType.IDENTIFIER) {
            factor = new Variable(lexer.getCurrentToken().getText());
        } 

        else if (lexer.getCurrentToken().getType() == TokenType.OPEN_PAREN) {
            lexer.fetchNextToken();
            factor = parseExpression();
            if (lexer.getCurrentToken().getType() != TokenType.CLOSED_PAREN) {
                factor = null;
            }
        } else {
            factor = null;
        }
        
        lexer.fetchNextToken();
        
        return factor;
    }
}
