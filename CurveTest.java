package control;

import graph.Graph;
import graph.Graph2D;
import graph.Graphable;
import graph.function.ellipticCurve.EllipticCurve;
import graph.function.polynomial.Cubic;
import graph.function.polynomial.Linear;
import graph.function.polynomial.Polynomial;
import graph.function.polynomial.Quadratic;
import gui.GraphPanel;

import javax.swing.*;
import java.awt.*;

public class CurveTest {

    public static void main(String[] args) {

        final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
        final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;

        float[] domain = new float[] { 10.0f, -10.0f};
        float[] range = new float[] { 20.0f, -20.0f };
        float interval = .02f;

        Graph graph = new Graph2D();
        graph.setViewBounds(0, domain);
        graph.setViewBounds(1, range);
        graph.setInterval(interval);

        Graphable ec1 = new EllipticCurve(2, -2, 0);
        Polynomial c1 = new Cubic(2, new float[] {1, 0, 0, 0});
        Polynomial q1 = new Quadratic(2, new float[]{1, 0, 0});
        Polynomial l1 = new Linear(2, new float[] {1, 6});

        graph.addGraphable(ec1);
        graph.addGraphable(c1);
        graph.addGraphable(q1);
        graph.addGraphable(l1);

        JFrame frame = new JFrame("Elliptic Curves");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setLocationRelativeTo(null);

        GraphPanel gp = new GraphPanel();
        gp.updateGraph(graph.getGraph(gp.getWidth(), gp.getHeight()));

        frame.add(gp);
        frame.setVisible(true);

    }


}
