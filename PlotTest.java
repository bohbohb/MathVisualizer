import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PlotTest {
    
    @Test
    public void testGetFunction() {
        Function f = new Function("1");
        Plot p = new Plot(f);
        assertSame(f, p.getFunction());
    }   
}
