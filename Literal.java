/**
 * A Literal is an AST node that 
 * corresponds to a literal integer value
 * (a number in the source code).
 */
public class Literal extends Node {
    
    private final int value;
    
    
    /**
     * Create a new Literal node.
     * @param value the integer value this node evaluates to
     */
    public Literal(final int value) {
        super();
        this.value = value;
    }

    @Override
    public Type getType() {
        return Type.INT;
    }

    @Override
    public boolean isConstant() {
        return true;
    }
    
    @Override
    public void compile(final Program p) {
        p.append(new BIPUSH(value));
    }

    @Override
    public String toString() {
        return "" + value;
    }
    
    
    
}
