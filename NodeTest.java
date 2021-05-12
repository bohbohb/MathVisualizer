import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests toString(), isConstant(), and getType() of Node subclasses.
 */
public class NodeTest {

    @Test
    public void testLiteral() {
        Node e = new Literal(5);
        assertTrue(e.isConstant());
        assertEquals("5", e.toString());
        assertEquals(Type.INT, e.getType());
    }
    
    @Test
    public void testVariable() {
        Node e = new Variable("x");
        assertFalse(e.isConstant());
        assertEquals("x", e.toString());
        assertEquals(Type.INVALID, e.getType());
    }
    // TODO test Variable class

    @Test
    public void testNegation() {
        Node e = new Negation(new Literal(5));
        assertTrue(e.isConstant());
        assertEquals("(-5)", e.toString());
        assertEquals(Type.INT, e.getType());
    }

    @Test
    public void testAddition() {
        Node e = new Addition(new Literal(5), new Literal(6));
        assertTrue(e.isConstant());
        assertEquals("(5+6)", e.toString());
        assertEquals(Type.INT, e.getType());
    }
    
    // TODO more tests of Addition

    @Test
    public void testSubtraction() {
        Node e = new Subtraction(new Literal(5), new Literal(6));
        assertTrue(e.isConstant());
        assertEquals("(5-6)", e.toString());
        assertEquals(Type.INT, e.getType());
    }
    
    @Test
    public void testSubtraction2() {
        Node e = new Subtraction(new Variable("x"), new Variable("y"));
        assertFalse(e.isConstant());
        assertEquals("(x-y)", e.toString());
        assertEquals(Type.INT, e.getType());
    }
    
    // TODO more tests of Subtraction

    // TODO test Multiplication
    @Test
    public void testMultiplication() {
        Node e = new Multiplication(new Literal(5), new Literal(6));
        assertTrue(e.isConstant());
        assertEquals("(5x6)", e.toString());
        assertEquals(Type.INT, e.getType());
    }
    // TODO test Division
    @Test
    public void testDivision() {
        Node e = new Division(new Literal(5), new Literal(6));
        assertTrue(e.isConstant());
        assertEquals("(5/6)", e.toString());
        assertEquals(Type.INT, e.getType());
    }
    
    
}
