package pplot;

import javax.swing.*;
import java.awt.*;

public class Inputs extends JPanel {
    private final JTextField weight_in = new JTextField("10");
    private final JTextField height_in = new JTextField("5");

    public Inputs(Calc c, Window frame) {
        // Object declarations
        JLabel weight = new JLabel("Peso W [lb] a usar:");
        JButton update = new JButton("Calcular");
        JLabel res1 = new JLabel("s1: " + String.format("%,.4f", c.getResult()[0]) + " [in]");
        JLabel res2 = new JLabel("s2: " + String.format("%,.4f", c.getResult()[1]) + " [in]");
        JLabel height = new JLabel("Altura h [ft] a usar:");

        // Setting up event listeners
        update.addActionListener(e -> {
                try {
                    double a1 = Double.parseDouble(weight_in.getText());
                    double a2 = Double.parseDouble(height_in.getText());

                    if (a1 > 0d) {
                        c.setWeight(a1);
                    } else {
                        c.setWeight(10d);
                        weight_in.setText("10");
                        JOptionPane.showMessageDialog(frame,
                                "Falta o se ingresó mal algún número.\nVolviendo a valores de inicio.",
                                "Error de datos!",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    if (a2 > 0d) {
                        c.setHeight(a2);
                    } else {
                        c.setHeight(5d);
                        weight_in.setText("5");
                        JOptionPane.showMessageDialog(frame,
                                "Falta o se ingresó mal algún número.\nVolviendo a valores de inicio.",
                                "Error de datos!",
                                JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException e1) {
                    c.setWeight(10d);
                    c.setHeight(5d);
                    weight_in.setText("10");
                    height_in.setText("5");
                    JOptionPane.showMessageDialog(frame,
                            "Falta o se ingresó mal algún número.\nVolviendo a valores de inicio.",
                            "Error de datos!",
                            JOptionPane.WARNING_MESSAGE);
                }
                c.reDoCalc();
                frame.reDoPlot();
                res1.setText("s1: " + String.format("%,.4f", c.getResult()[0]) + " [in]");
                res1.revalidate();
                res2.setText("s2: " + String.format("%,.4f", c.getResult()[1]) + " [in]");
                res2.revalidate();
        });

        // Setting up the grid layout
        setLayout( new GridBagLayout() );
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10,10, 10);

        // First level
        gbc.gridwidth = 2;
        gbc.gridy = 0;

        gbc.gridx = 0;
        add(weight, gbc);

        gbc.gridwidth = 4;

        gbc.gridx = 2;
        weight_in.setPreferredSize(new Dimension(80,20));
        add(weight_in, gbc);

        gbc.gridwidth = 2;

        gbc.gridx = 6;
        add(Box.createHorizontalStrut(120), gbc);

        gbc.gridx = 8;
        add(update, gbc);

        gbc.gridx = 10;
        add(res1, gbc);

        gbc.gridx = 12;
        add(res2, gbc);

        // Second level
        gbc.gridwidth = 2;
        gbc.gridy = 1;

        gbc.gridx = 0;
        add(height, gbc);

        gbc.gridwidth = 4;

        gbc.gridx = 2;
        height_in.setPreferredSize(new Dimension(80,20));
        add(height_in, gbc);

        gbc.gridwidth = 2;

        gbc.gridx = 6;
        add(Box.createHorizontalStrut(120), gbc);

        // Third level
        gbc.gridwidth = 2;
        gbc.gridy = 2;

        gbc.gridx = 0;
        add(new JLabel("Valores positivos, peso mayor a 0"), gbc);

    }

}
