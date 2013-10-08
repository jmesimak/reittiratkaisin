package algoritmit;

import aputyokalut.AlustajaBellmanFord;
import aputyokalut.SolmuBellmanFord;
/**
 * Myös negatiivisilla kaaripainoilla varustettuja verkkoja ratkaiseva algoritmi, jonka tehtävänä tässä ohjelmassa on havainnollistaa kyseisen toimenpiteen hitaus.
 * @author Jerry
 */
public class BellmanFord {

    /**
     * Bellman-Ford -algoritmin alustaja
     */
    private AlustajaBellmanFord alustaja;
    /**
     * Solmuesitys luolastosta
     */
    private SolmuBellmanFord[][] solmut;

    /**
     * Alustetaan alustaja
     */
    public BellmanFord() {
        this.alustaja = new AlustajaBellmanFord();
    }

    /**
     * Ratkaisee ja tallentaa ratkaistun luolaston
     * @param luolasto Luolaston esitys kokonaislukutaulukkona
     */
    public void ratkaiseLuolasto(int[][] luolasto) {
        this.alustaja.alustaLuolastoSolmuiksi(luolasto);
        this.solmut = this.alustaja.getSolmut();

        for (int k = 0; k < this.solmut.length; k++) {
            for (int i = 0; i < solmut.length; i++) {
                for (int j = 0; j < solmut[0].length; j++) {
                    if (solmut[i][j].getTunniste() == 1) {
                        if (i - 1 >= 0 && solmut[i - 1][j].getTunniste() == 1) {
                            loysaa(solmut[i][j], solmut[i - 1][j]);
                        }
                        if (i + 1 <= solmut.length - 1 && solmut[i + 1][j].getTunniste() == 1) {
                            loysaa(solmut[i][j], solmut[i + 1][j]);
                        }
                        if (j - 1 >= 0 && solmut[i][j - 1].getTunniste() == 1) {
                            loysaa(solmut[i][j], solmut[i][j - 1]);
                        }
                        if (j + 1 <= solmut[0].length - 1 && solmut[i][j + 1].getTunniste() == 1) {
                            loysaa(solmut[i][j], solmut[i][j + 1]);
                        }
                    }
                }
            }
        }

    }

    /**
     * Verrataan läpikäytävää solmua sen naapuriin
     * @param eka Läpikäytävä solmu
     * @param toka Naapurisolmu
     */
    private void loysaa(SolmuBellmanFord eka, SolmuBellmanFord toka) {
        if (toka.getEtaisyysLahtoSolmusta() > eka.getEtaisyysLahtoSolmusta() + 1) {
            toka.setEtaisyysLahtosolmusta(eka.getEtaisyysLahtoSolmusta() + 1);
        }
    }

    /**
     * @return Palauttaa luolaston solmumuotoisen esityksen
     */
    public SolmuBellmanFord[][] getSolmut() {
        return this.solmut;
    }

    /**
     * @return Lyhimmän reitin pituus lähtöruudusta maaliruutuun.
     */
    public int getLyhimmanReitinPituus() {
        return this.solmut[solmut.length - 1][solmut[0].length - 1].getEtaisyysLahtoSolmusta();
    }
}
