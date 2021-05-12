import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests toString() and execute() of Instruction subclasses.
 */
public class InstructionTest {
    
    @Test
    public void testToStringBIPUSH() {
        Instruction i = new BIPUSH(1);
        assertEquals("BIPUSH 1", i.toString());
    }
    
    @Test
    public void testExecuteBIPUSH() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        Instruction i = new BIPUSH(1);
        i.execute(s);
        assertEquals(1, os.pop());
    }
    
    
    @Test
    public void testToStringINEG() {
        Instruction i = new INEG();
        assertEquals("INEG", i.toString());
    }
    
    @Test
    public void testExecuteINEG() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.push(1);
        Instruction i = new INEG();
        i.execute(s);
        assertEquals(-1, os.pop());
    }

    
    @Test
    public void testToStringIADD() {
        Instruction i = new IADD();
        assertEquals("IADD", i.toString());
    }
    
    @Test
    public void testExecuteIADD() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.push(1);
        os.push(2);
        Instruction i = new IADD();
        i.execute(s);
        assertEquals(3, os.pop());
    }

    
    @Test
    public void testToStringISUB() {
        Instruction i = new ISUB();
        assertEquals("ISUB", i.toString());
    }
    
    @Test
    public void testExecuteISUB() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.push(2);
        os.push(3);
        Instruction i = new ISUB();
        i.execute(s);
        assertEquals(1, os.pop());
    }

    
    // TODO Add tests for ILOAD, IMUL, and IDIV
    @Test
    public void testToStringILOAD() {
        Instruction i = new ILOAD("x");
        assertEquals("ILOAD x", i.toString());
    }
    
    @Test
    public void testExecuteILOAD() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        Instruction i = new ILOAD("x");
        vt.set("x", 5);
        i.execute(s);
        assertEquals(5, os.pop());
    }
    
    @Test
    public void testToStringIMUL() {
        Instruction i = new IMUL();
        assertEquals("IMUL", i.toString());
    }
    
    @Test
    public void testExecuteIMUL() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.push(3);
        os.push(2);
        Instruction i = new IMUL();
        i.execute(s);
        assertEquals(6, os.pop());
    }
    
    @Test
    public void testToStringIDIV() {
        Instruction i = new IDIV();
        assertEquals("IDIV", i.toString());
    }
    
    @Test
    public void testExecuteIDIV() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        os.push(2);
        os.push(2);
        Instruction i = new IDIV();
        i.execute(s);
        assertEquals(1, os.pop());
    }
    
    @Test 
    public void testExecuteLoadAdd() {
        OperandStack os = new OperandStack();
        VariableTable vt = new VariableTable();
        Storage s = new Storage(os, vt);
        vt.set("x",5);
        Instruction i1 = new ILOAD("x");
        os.push(5);
        i1.execute(s);
        Instruction i = new IADD();
        i.execute(s);
        assertEquals(10, os.pop());
        
    }
    
}
