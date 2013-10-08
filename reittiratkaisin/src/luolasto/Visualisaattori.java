package luolasto;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * Swing JFrame, joka määrittelee mitä sen sisältä löytyy ja käskee Ruutua piirtämään sisällön.
 * @author Jerry
 */
public class Visualisaattori extends JFrame {

    public static Dimension size;
    private Ruutu ruutu;

    public Visualisaattori(int[][] luolasto, int koko) {
        size = new Dimension(luolasto.length*11, luolasto.length*11);
        setSize(size);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 1, 0, 0));
        ruutu = new Ruutu(luolasto);
        JScrollPane scrRuutu = new JScrollPane(ruutu);
        add(scrRuutu);
    }

    public void visualisoi() {
        ruutu.repaint();
        setVisible(true);
    }
}
