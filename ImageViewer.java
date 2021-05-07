import java.awt.*;
import javax.swing.*;

/**
 * Font -> to The Font class represents fonts, which are used to render text in a visible way.
 */

/**
 * Create a GUI ImageViewer
 * 
 * @author Federico Lombardo & Alessandro Cagnani
 * @version 7/5/2021
 */
public class ImageViewer 
{
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private JFrame frame;

    /**
     * Costruttore degli oggetti di classe  ImageViewer
     */
    public ImageViewer()
    {
        makeFrame();
    }

    /**
     * This create the frame and get as input the formula.
     * 
     */
    public void makeFrame()
    {
        frame = new JFrame("Math Formula Visualizer");
        Container contentPane = frame.getContentPane();
        
        String formula = JOptionPane.showInputDialog(null, "Enter your Formula : ");
        JLabel label = new JLabel("The Formula is: " + formula );
        contentPane.add(label);
        
        frame.setMinimumSize(new Dimension(600,400));
        frame.pack();
        frame.setVisible(true);
    }
}
