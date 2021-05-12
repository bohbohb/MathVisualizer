
/**
 * An integer moltiplication.
 */
public class Multiplication extends Node
{
    
    private final Node leftChild;
    private final Node rightChild;

    /**
     * Costruttore degli oggetti di classe  Division.
     * @param leftChild the left operand
     * @param rightChild the right operand
     */
    public Multiplication(final Node leftChild, final Node rightChild)
    {
        super();
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    
    @Override
    public Type getType() {
        return Type.INT;
    }
    
    @Override
    public boolean isConstant() {
        return leftChild.isConstant() && rightChild.isConstant();
    }
    
    
    @Override
    public void compile(final Program p) {
        leftChild.compile(p);
        rightChild.compile(p);
        p.append(new IMUL());
    }
    
    
    @Override
    public String toString() {
        return "(" + leftChild.toString() + "x" + rightChild.toString() + ")";
    }
    
    
}
