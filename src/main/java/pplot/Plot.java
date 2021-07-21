package pplot;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;

public class Plot extends JPanel {
    Calc c;
    JPanel chart_panel;
    JFreeChart chart;

    public Plot(Calc c) {
        this.c = c;
        doPlot();
    }

    private void doPlot() {
        chart = ChartFactory.createXYLineChart("Compresión en función del peso", "Peso [lb]", "s1 [in]", c.getDataset());
        chart_panel = new ChartPanel(chart);
        chart_panel.setPreferredSize(new Dimension(400,300));
        add(chart_panel, BorderLayout.CENTER);
    }

    public void update() {
        chart = null;
        this.remove(chart_panel);
        doPlot();
        this.revalidate();
    }

}
