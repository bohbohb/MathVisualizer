import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;


/**
 * The PlotCanvas is part of the GUI.
 * It is a custom component, which draws itself
 * (in the paintComponent method)
 * and which provides information on how big it would like to be
 * (via the getPreferredSize method).
 */
public final class PlotCanvas extends JComponent {

    private static final Dimension PREFERRED_SIZE = new Dimension(400, 300);
    
    private final Function function;
    
    
    
    /**
     * Create a PlotCanvas for the given Plot.
     * @param plot The Plot to show
     */
    public PlotCanvas(final Plot plot) {
        super();
        this.function = plot.getFunction();
        
        // register listener
        function.addFunctionListener(new FunctionListener() {
            public void functionChanged(final Function function) {
                repaint();
            }
        });
    }
    
    @Override
    public Dimension getPreferredSize() {
        return PREFERRED_SIZE;
    }
    
    @Override
    public void paintComponent(final Graphics g) {
        
        /**
         * TODO: show the well formatted fraction
         */
    
    }
}