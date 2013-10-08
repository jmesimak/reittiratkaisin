package reittiratkaisin;

import algoritmit.Astar;
import algoritmit.BellmanFord;
import algoritmit.Dijkstra;
import java.util.Scanner;
import luolasto.LuolastoGeneraattori;
import luolasto.Ruutu;
import luolasto.Visualisaattori;
import sun.net.www.content.image.gif;

/**
 * Pääohjelma, jonka kautta algoritmeja tarkastellaan.
 * @author Jerry
 */
public class Reittiratkaisin {

    static LuolastoGeneraattori lg = new LuolastoGeneraattori();
    static Astar a = new Astar();
    static BellmanFord b = new BellmanFord();
    static Dijkstra d = new Dijkstra();
    static Scanner lukija = new Scanner(System.in);

    public static void main(String[] args) {

        boolean visualisoidaanko = false;

        System.out.print("Visualisoidaanko (k/e)?: ");
        if (lukija.nextLine().equals("k")) {
            visualisoidaanko = true;
        }

        System.out.print("Syötä luolaston sivun pituus kokonaislukuna: ");
        int koko = lukija.nextInt();
        lg.generoiLuolasto(koko);
        int[][] luolasto = lg.getLuolasto();

        double ekaA = System.currentTimeMillis();
        a.ratkaiseLuolasto(luolasto);
        System.out.println("A* - Aika: " + (System.currentTimeMillis() - ekaA) + " Tulos: " + a.getLyhimmanReitinPituus());

        double ekaB = System.currentTimeMillis();
        b.ratkaiseLuolasto(luolasto);
        System.out.println("Bellman-Ford - Aika: " + (System.currentTimeMillis() - ekaB) + " Tulos: " + b.getLyhimmanReitinPituus());

        double ekaD = System.currentTimeMillis();
        d.ratkaiseLuolasto(luolasto);
        d.muunnaReitti();
        System.out.println("Dijkstra - Aika: " + (System.currentTimeMillis() - ekaD) + " Tulos: " + d.getLyhimmanReitinPituus());

        if (visualisoidaanko) {
            Visualisaattori v = new Visualisaattori(luolasto, koko);
            v.visualisoi();
        }
    }
}
