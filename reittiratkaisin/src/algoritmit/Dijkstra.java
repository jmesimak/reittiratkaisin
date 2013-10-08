package algoritmit;

import aputietorakenteet.MinimikekoDijkstra;
import aputyokalut.AlustajaDijkstra;
import aputyokalut.SolmuDijkstra;
/**
 * Nopea painotettuja verkkoja käsittelevä algoritmi.
 * @author Jerry
 */
public class Dijkstra {

    /**
     * Dijkstralle spesifi alustaja
     */
    private AlustajaDijkstra alustaja;
    /**
     * Solmut, jotka muodostavat luolaston
     */
    private SolmuDijkstra[][] solmut;
    /**
     * Minimikeko, johon tallennetaan läpikäytäviä solmuja
     */
    private MinimikekoDijkstra jono;
    /**
     * Luolaston kokonaislukuesitys, jota käpistellään visualisointia varten
     */
    private int[][] luolasto;
       
    /**
     * Alustetaan alustaja
     */
    public Dijkstra() {
        this.alustaja = new AlustajaDijkstra();
    }

    /**
     * Ratkaistaan luolasto tehokkaasti
     * @param luolasto Kokonaislukuesitys luolastosta
     */
    public void ratkaiseLuolasto(int[][] luolasto) {
        this.luolasto = luolasto;
        this.alustaja.alustaLuolastoSolmuiksi(luolasto);
        this.solmut = this.alustaja.getSolmut();
        this.jono = new MinimikekoDijkstra(luolasto.length*luolasto[0].length);
        this.jono.lisaaKekoon(solmut[0][0]);

        while (!jono.onkoTyhja()) {
            SolmuDijkstra lapikaytava = jono.poistaPienin();
            if (lapikaytava.getTunniste() == 1) {
                if (lapikaytava.getY() - 1 >= 0 && solmut[lapikaytava.getY() - 1][lapikaytava.getX()].getTunniste() == 1) {
                    loysaa(lapikaytava, solmut[lapikaytava.getY() - 1][lapikaytava.getX()]);
                }
                if (lapikaytava.getY() + 1 <= solmut.length - 1 && solmut[lapikaytava.getY() + 1][lapikaytava.getX()].getTunniste() == 1) {
                    loysaa(lapikaytava, solmut[lapikaytava.getY() + 1][lapikaytava.getX()]);
                }
                if (lapikaytava.getX() - 1 >= 0 && solmut[lapikaytava.getY()][lapikaytava.getX() - 1].getTunniste() == 1) {
                    loysaa(lapikaytava, solmut[lapikaytava.getY()][lapikaytava.getX() - 1]);
                }
                if (lapikaytava.getX() + 1 <= solmut.length - 1 && solmut[lapikaytava.getY()][lapikaytava.getX() + 1].getTunniste() == 1) {
                    loysaa(lapikaytava, solmut[lapikaytava.getY()][lapikaytava.getX() + 1]);
                }
            }
        }
    }

    /**
     * Dijkstran relax-metodi, jossa vertaillaan läpikäytävän ja sen naapurien etäisyyttä
     * @param eka Läpikäytävä solmu
     * @param toka Naapurisolmu
     */
    private void loysaa(SolmuDijkstra eka, SolmuDijkstra toka) {
        if (toka.getEtaisyysLahtoSolmusta() > eka.getEtaisyysLahtoSolmusta() + 1) {
            toka.setEtaisyysLahtoSolmusta(eka.getEtaisyysLahtoSolmusta() + 1);
            toka.setPrev(eka);
            this.jono.lisaaKekoon(toka);
        }
    }

    /**
     * 
     * @return Palautetaan tieto siitä mikä on lyhimmän reitin pituus maalista loppuun.
     */
    public int getLyhimmanReitinPituus() {
        return this.solmut[solmut.length - 1][solmut[0].length - 1].getEtaisyysLahtoSolmusta();
    }

    /**
     * Muuntaa tallennetun reittijonon kokonaislukuesitykseksi helpompaa visualisointia varten.
     */
    public void muunnaReitti() {
        SolmuDijkstra d = this.solmut[solmut.length - 1][solmut[0].length - 1];
        luolasto[0][0] = 2;
        while (d.getPrev() != null) {
            luolasto[d.getY()][d.getX()] = 2;
            d = d.getPrev();
        }
    }
}
