import java.awt.*;
import javax.swing.*;

/**
 * Create a GUI ImageViewer
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
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
     * Un esempio di metodo - aggiungi i tuoi commenti
     * 
     * @param  y   un parametro d'esempio per un metodo
     * @return     la somma di x e y
     */
    public void makeFrame()
    {
        frame = new JFrame("Math Formula Visualizer");
        Container contentPane = frame.getContentPane();
        
        JLabel label = new JLabel("Formula : ");
        contentPane.add(label);
        
        frame.setMinimumSize(new Dimension(600,400));
        frame.pack();
        frame.setVisible(true);
    }
}
