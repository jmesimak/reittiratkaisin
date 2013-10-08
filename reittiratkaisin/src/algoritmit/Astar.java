package algoritmit;

import aputietorakenteet.MinimikekoAstar;
import aputyokalut.AlustajaAstar;
import aputyokalut.SolmuAstar;

/**
 * Heuristiikkaa hyväkseen käyttävä algoritmi, joka toimii muuten samalla tavalla kuin Dijkstra, mutta edetessään se arvioi jokaisen verkon solmun
 * etäisyyttä maalisolmusta ja keskittää etsimistä tämän avulla.
 * @author Jerry
 */
public class Astar {

    /**
     * A*-algoritmin oma alustaja.
     */
    private AlustajaAstar alustaja;
    /**
     * Solmut, jotka muodostavat luolaston.
     */
    private SolmuAstar[][] solmut;
    /**
     * Minimikeko, johon laitetaan solmuja sen perusteella mikä niiden yhteenlaskettu etäisyys lähtöruutuun ja maaliruutuun on.
     */
    private MinimikekoAstar jono;

    /**
     * Alustetaan alustaja.
     */
    public Astar() {
        this.alustaja = new AlustajaAstar();
    }

    /**
     * Ratkaisee ja tallentaa ratkaistun luolaston.
     * @param luolasto Kokonaislukutaulukko, joka esittää luolastoa.
     */
    public void ratkaiseLuolasto(int[][] luolasto) {
        this.alustaja.alustaLuolastoSolmuiksi(luolasto);
        this.solmut = this.alustaja.getSolmut();

        this.jono = new MinimikekoAstar(luolasto.length*luolasto[0].length);
        this.jono.lisaaKekoon(solmut[0][0]);
        solmut[0][0].setYhdistettyEtaisyys();

        while (!jono.onkoTyhja()) {
            SolmuAstar lapikaytava = jono.poistaPienin();
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
     * A*:in oma löysäysmetodi, jonka aikana vertaillaan läpikäytävän etäisyyttää sen naapureihin. Naapurit laitetaan kekoon odottamaan käsittelyä.
     * @param eka Läpikäytävä solmu.
     * @param toka Läpikäytävän naapurisolmu.
     */
    private void loysaa(SolmuAstar eka, SolmuAstar toka) {
        if (toka.getEtaisyysLahtoSolmusta() > eka.getEtaisyysLahtoSolmusta() + 1) {
            toka.setEtaisyysLahtoSolmusta(eka.getEtaisyysLahtoSolmusta() + 1);
            toka.setYhdistettyEtaisyys();
            jono.lisaaKekoon(toka);
            
        }
    }

    /**
     * @return Palauttaa lyhimmän reitin etäisyyden lähtösolmusta. 
     */
    public int getLyhimmanReitinPituus() {
        return this.solmut[solmut.length - 1][solmut[0].length - 1].getEtaisyysLahtoSolmusta();
    }
}
