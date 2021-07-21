package pplot;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {
    // Creating values for plot
    Calc c = new Calc();
    // Declaring window object
    JFrame frame;
    // For reformatting the plot
    UpperContainer upc = new UpperContainer(c);

    public Window() {
        doFrame();
    }

    // Instancing the frame
    private void doFrame() {
        // Frame config
        frame = new JFrame("Validación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(upc, BorderLayout.NORTH);        // WIP
        frame.add(new Inputs(c, this), BorderLayout.SOUTH);
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    // Redrawing at demand
    public void reDoPlot() {
        upc.updatePlot();
    }
}
