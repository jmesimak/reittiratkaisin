package luolasto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JPanel;

/**
 *  Piirrettävä graafinen ruutu, jonka sisältöön ei sen tarkemmin mennä
 * @author Jerry
 */
public class Ruutu extends JPanel {

    private int[][] luolasto;
    private Scanner lukija;
    public static boolean piirraReitti = false;

    public Ruutu(int[][] luolasto) {
        this.luolasto = luolasto;
        this.lukija = new Scanner(System.in);
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < luolasto.length; i++) {
            for (int j = 0; j < luolasto[0].length; j++) {
                if (luolasto[i][j] == 0) {
                    g.setColor(Color.black);
                    g.fillRect(j * 10, i * 10, 10, 10);
                } else if (luolasto[i][j] == 1) {
                    g.setColor(Color.white);
                    g.fillRect(j * 10, i * 10, 10, 10);
                } else {
                    g.setColor(Color.red);
                    g.fillRect(j * 10, i * 10, 10, 10);
                }
            }
        }
    }
}
