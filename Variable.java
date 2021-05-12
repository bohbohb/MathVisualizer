
/**
 * An integer variable.
 */
public class Variable extends Node
{
    private final String name;

    /**
     * Costruttore degli oggetti di classe  Variable.
     * @param name name of the variable.
     */
    public Variable(final String name)
    {
        super();
        this.name = name;
    }
    
    @Override
    public Type getType() {
        return Type.INVALID;
    }
    
    @Override
    public boolean isConstant() {
        return false;
    }
    
    
    @Override
    public void compile(final Program p) {
        p.append(new ILOAD(name));
    }

   
    @Override
    public String toString() {
        return name;
    }
}
