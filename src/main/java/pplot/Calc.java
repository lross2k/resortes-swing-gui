package pplot;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Calc {
    // Declaring plot dependencies
    private XYSeries series;
    private XYSeriesCollection dataset;

    // Declaring variables
    private double v_W, v_h, s1, s2;
    private final int v_k1, v_k2, v_diff;
    private int n_data;

    // X and Y axes
    private double[] x_arr;
    private double[] y_arr;

    // Constructor
    public Calc() {
        v_W = 10d;
        v_h = 5;
        v_k1 = 30;
        v_k2 = 45;
        v_diff = 3;

        doCalc();
    }

    // To re-calculate the values
    private void doCalc() {
        float PRECISION = 0.01f;                             // Increment later
        n_data = (int) ((this.v_W - PRECISION)/PRECISION);

        // Array instancing
        x_arr = new double[n_data];
        y_arr = new double[n_data];

        for (int i = 0; i < n_data; i ++) {
            x_arr[i] = 0.1d + PRECISION*i;
            double a = -(v_k1/2.0 + v_k2/2.0);
            double b = (x_arr[i] + v_k2*v_diff);
            double c = 12*v_h*x_arr[i] - v_k2/2.0*Math.pow(v_diff,2);
            final double disc = Math.sqrt(Math.pow(b,2) - 4*a*c);
            double y1 = (-b + disc)/(2*a);
            double y2 = (-b - disc)/(2*a);
            y_arr[i] = y1 > 0.0 ? y1 : y2;      // adds s1 to the array
        }

        //  -(k1/2.0 + k2/2.0)*y^2 + (W + k2/2.0*2*y_diff)*y + (12*h*W - k2/2.0*y_diff^2) = 0

        double a = -(v_k1/2.0 + v_k2/2.0);
        double b = (v_W + v_k2*v_diff);
        double c = 12*v_h*v_W - v_k2/2.0*Math.pow(v_diff,2);
        final double disc = Math.sqrt(Math.pow(b,2) - 4*a*c);
        double y1 = (-b + disc)/(2*a);
        double y2 = (-b - disc)/(2*a);
        s1 = y1 > 0.0 ? y1 : y2;
        s2 = s1 - v_diff;

        doDataset();
    }

    // To update the values
    private void doDataset() {
        series = new XYSeries("s1 - W");
        dataset = new XYSeriesCollection(series);

        for (int i = 0; i < n_data; i ++) {
            series.add(x_arr[i],y_arr[i]);
        }
    }

    // Returns the x and y axis
    public XYSeriesCollection getDataset() {
        return this.dataset;
    }

    public void reDoCalc() {
        x_arr = null;
        y_arr = null;
        series = null;
        dataset = null;
        doCalc();
    }

    public double[] getResult() {
        return new double[]{s1, s2};
    }

    public void setWeight(double v_W) {
        this.v_W = v_W;
    }

    public void setHeight(double v_h) { this.v_h = v_h; }
}
