import java.util.ArrayList;


/**
 * The Function is the most important part of the "model" 
 * in our function plotter application.
 * The "model" does not know anything about the "GUI".
 * It could exist without "GUI" (e.g., for a command-line interface).
 */
public final class Function {

    private final ArrayList<FunctionListener> listeners;
    private String expressionText;
    // private final ArrayList<Fractions> fractions;
    private Program program;
    
    
    /**
     * Create a Function based on the given expression.
     * @param expressionText The expression (a function of x).
     */
    public Function(final String expressionText) {
        //TODO initialization
        listeners = new ArrayList<FunctionListener>();
        setExpression(expressionText);
    }
    
    /**
     * Change the expression underlying this Function.
     * @param expressionText The new expression (a function of x).
     */
    public final void setExpression(final String expressionText) {
        this.expressionText = expressionText;
        final Parser parser = new ArithParser();
        final Node parsedExpression = parser.parse(expressionText);
        program = new Program();

        parsedExpression.compile(program);
        fireFunctionChanged();
    }
    
    /**
     * Get the expression defining this function.
     * @return the expression.
     */
    public final String getExpression() {
        return expressionText;
    }
    
    //--- listener management
    // TODO: addFunctionListener, removeFunctionListener
    /**
     * Register the given FunctionListener,
     * so it will be notified whenever this Function changes.
     * @param li The FunctionListener to register
     */
    public final void addFunctionListener(final FunctionListener li) {
        listeners.add(li);
    }
    
    /**
     * Unregister the given FunctionListener,
     * so it will not be notified anymore whenever this Function changes.
     * @param li The FunctionListener to unregister
     */
    public final void removeFunctionListener(final FunctionListener li) {
        listeners.remove(li);
    }
    
    // TODO: fireFunctionChanged
    /**
     * Notify all registered FunctionListener that this Function has changed.
     */
    private void fireFunctionChanged() {
        for (final FunctionListener li : listeners) {
            li.functionChanged(this);
        }
    }
}