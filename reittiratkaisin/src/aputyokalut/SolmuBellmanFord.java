package aputyokalut;

/**
 * Solmut, joita Bellman-Ford käsittelee.
 * @author Jerry
 */
public class SolmuBellmanFord {

    /**
     * Etäisyys lähdöstä.
     */
    private int etaisyysLahtoSolmusta;
    /**
     * Solmun syvin olemus.
     */
    private int tunniste;

    /**
     * Kerrotaan mitä laatua solmu on.
     * @param tunniste Kokonaislukutunniste
     */
    public SolmuBellmanFord(int tunniste) {
        this.tunniste = tunniste;
    }

    public void setEtaisyysLahtosolmusta(int uusiEtaisyys) {
        this.etaisyysLahtoSolmusta = uusiEtaisyys;
    }

    public int getEtaisyysLahtoSolmusta() {
        return this.etaisyysLahtoSolmusta;
    }

    public int getTunniste() {
        return this.tunniste;
    }
}