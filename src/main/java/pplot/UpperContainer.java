package pplot;

import javax.swing.*;
import java.awt.*;

public class UpperContainer extends JPanel {
    Calc c;
    Plot plot;           // new PLot();

    public UpperContainer(Calc c) {
        // Object declarations
        ImagePanel img = new ImagePanel();
        this.c = c;
        plot = new Plot(c);

        // Setting up the grid layout
        setLayout( new GridBagLayout() );
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10,0, 10);

        gbc.gridwidth = 2;
        gbc.gridy = 0;

        gbc.gridx = 0;
        add(img, gbc);          // Image container

        gbc.gridx = 2;
        add(Box.createHorizontalStrut(20), gbc);

        gbc.gridx = 4;
        add(plot, gbc);         // Plot container
    }

    public void updatePlot() {
        plot.update();
    }

}
