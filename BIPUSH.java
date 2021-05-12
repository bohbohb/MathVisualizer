/**
 * BIPUSH pushes the given value onto the operand stack.
 */
public class BIPUSH extends Instruction {
    
    private final int value;
    
    /**
     * constructor for BIPUSH.
     * @param value to be pushed onto the OS.
     */
    public BIPUSH(final int value) {
        super();
        this.value = value;
    }
    
    @Override
    public void execute(final Storage storage) {
        storage.getOperandStack().push(value);
    }
    
    @Override
    public String toString() {
        return "BIPUSH " + value;
    }

}
