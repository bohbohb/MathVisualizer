import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FunctionTest {
    
    @Test
    public void testSetGetExpression() {
        Function function = new Function("x/x");
        assertEquals("x/x", function.getExpression());
    }
    /**
    @Test
    public void testCompute() {
        Function function = new Function("x*2");
        assertEquals(6.0, function.compute(3), 0.001);
    }
    */
    @Test
    public void testAddFunctionListener() {
        // TODO: uncomment this test once you implemented addFunctionListener()
        
        Function function = new Function("x");
        class TestFunctionListener implements FunctionListener {
            public boolean gotNotified = false;
            public boolean gotNotifiedForFunction = false;
            public void functionChanged(Function f) {
                gotNotified = true;
                gotNotifiedForFunction = f == function;
            }
        }
        TestFunctionListener li = new TestFunctionListener();
        function.addFunctionListener(li);
        function.setExpression("x*x");
        assertTrue(li.gotNotified);
        assertTrue(li.gotNotifiedForFunction);
        
    }
    
    @Test
    public void testRemoveFunctionListener() {
        // TODO: uncomment this test once you implemented addFunctionListener()
        //       and removeFunctionListener()
        
        Function function = new Function("x");
        class TestFunctionListener implements FunctionListener {
            public boolean gotNotified = false;
            public boolean gotNotifiedForFunction = false;
            public void functionChanged(Function f) {
                gotNotified = true;
                gotNotifiedForFunction = f == function;
            }
        }
        TestFunctionListener li = new TestFunctionListener();
        function.addFunctionListener(li);
        function.removeFunctionListener(li);
        function.setExpression("x*x");
        assertFalse(li.gotNotified);
        assertFalse(li.gotNotifiedForFunction);
        
    }
    
}
