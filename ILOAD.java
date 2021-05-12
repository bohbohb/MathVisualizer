
/**
 * ILOAD class.
 */
public class ILOAD extends Instruction
{
    
    private final String var;

    /**
     * Costruttore degli oggetti di classe  ILOAD.
     * @param var the variable name
     */
    public ILOAD(final String var)
    {
        super();
        this.var = var;
    }
    
    @Override
    public void execute(final Storage storage) {
        storage.getOperandStack().push(storage.getVariableTable().get(var));
    }
    
    @Override
    public String toString() {
        return "ILOAD " + var;
    }

}
