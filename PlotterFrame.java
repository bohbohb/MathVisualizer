import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * The main frame of the Function Plotter application.
 * The "GUI".
 * The "GUI" knows the "model", it depends on the "model",
 * and it cannot exist without the "model".
 * The "model" of a PlotterFrame is a Plot.
 */
public final class PlotterFrame extends JFrame {

    /**
     * Create a new PlotterFrame for the given Plot.
     * @param plot The model to show.
     */
    public PlotterFrame(final Plot plot) {
        super();
        setTitle("Math Formula Visualizer");
        setLayout(new BorderLayout());
        final JTextField expressionField = new JTextField(plot.getFunction().getExpression());
        add(expressionField, BorderLayout.NORTH);
        
        final JPanel canvases = new JPanel(new BorderLayout());
        // DODO: add canvas where you show the fraction
        
        // register listeners
        expressionField.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent ev) {
                // called when user presses ENTER key in expressionField
                final String text = expressionField.getText();
                plot.getFunction().setExpression(text);
            }
        });
        pack();
    }
    
}