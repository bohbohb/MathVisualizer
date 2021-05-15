/**
 * An integer subtraction.
 */
public class Fraction extends Node {
    
    private final Node numerator;
    private final Node denominator;
    
    
    /**
     * Create a new Fraction node.
     * @param leftChild the left operand
     * @param rightChild the right operand
     */
    public Fraction(final Node numerator, final Node denominator) {
        super();
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public Type getType() {
        return Type.INT;
    }
    
    @Override
    public boolean isConstant() {
        return numerator.isConstant() && denominator.isConstant();
    }
    
    
    @Override
    public void compile(final Program p) {
        numerator.compile(p);
        denominator.compile(p);
        p.append(new IDIV());
    }
    
    
    @Override
    public String toString() {
        return "(" + numerator.toString() + "/" + denominator.toString() + ")";
    }
    
}
