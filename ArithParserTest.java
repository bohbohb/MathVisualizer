import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * This test class will test some aspects of the rules
 * of the Arith language.
 * 
 * <code>
 * EXPRESSION   ::= [ "+" | "-" ] TERM { ( "+" | "-" ) TERM }
 * TERM         ::= FACTOR { ( "*" | "/" ) FACTOR }
 * FACTOR       ::= Literal | 
 *                  Identifier| 
 *                  "(" EXPRESSION ")"
 * </code>
 */
public class ArithParserTest {

    @Test
    public void testLiteral() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Literal(12);
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testVariable() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "x";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Variable("x");
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testNegation() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "-11";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Negation(new Literal(11));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }
    

    @Test
    public void testUnaryPlus() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "+11";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Literal(11);
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testAddition() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12+2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Addition(new Literal(12), new Literal(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }
    
    @Test
    public void testAddition2() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12+2+2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Addition(new Literal(12), new Addition(new Literal(2),new Literal(2)));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }
    
    @Test
    public void testAddition3() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "-1+2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Addition(new Negation(new Literal(1)), new Literal(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }
    
    @Test
    public void testAddition4() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "+1+2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Addition(new Literal(1), new Literal(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testSubtraction() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12-2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Subtraction(new Literal(12), new Literal(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testMultiplication() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12*2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Multiplication(new Literal(12), new Literal(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }
    
    @Test
    public void testMultiplication2() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12*2*2*2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Multiplication(new Literal(12), new Multiplication(new Literal(2), new Multiplication(new Literal(2),new Literal(2))));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }
    
    @Test
    public void testMulDiv() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12*2*2/2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Multiplication(new Literal(12), new Multiplication(new Literal(2), new Division(new Literal(2),new Literal(2))));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testDivision() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "12/2";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Division(new Literal(12), new Literal(2));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }

    @Test
    public void testParentheses() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "(12)";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Literal(12);
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }
    
    @Test
    public void testParentheses2() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "(12+1*2)";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Addition(new Literal(12), new Multiplication(new Literal(1),new Literal(2)));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }
    
    @Test
    public void testParenthesesNested() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "(12+(1*2))";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Addition(new Literal(12), new Multiplication(new Literal(1),new Literal(2)));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }
    
    @Test
    public void testParenthesesNested2() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "(12+(1*2)+1)";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        // expected tree
        final Node expectedRoot = new Addition(new Literal(12), new Addition(new Multiplication(new Literal(1),new Literal(2)), new Literal(1)));
        // assertion
        assertEquals(expectedRoot.toString(), actualRoot.toString());
    }
    
    @Test
    public void testParenthesesNested3() {
        // setup
        final Parser parser = new ArithParser();
        // test input
        final String sourceCode = "1+(2+(3+(4+(5+6))))+7+8";
        // code under test
        final Node actualRoot = parser.parse(sourceCode);
        
        System.out.println(actualRoot.toString());
    }
}
