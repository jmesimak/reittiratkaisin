package aputyokalut;

/**
 * Dijkstran käyttämä solmu, jossa pidetään yllä tietoa solmun paikasta, sen edeltäjästä ja etäisyydestä lähtösolmuun.
 * @author Jerry
 */
public class SolmuDijkstra implements Comparable<SolmuDijkstra> {

    /**
     * Solmun olemus
     */
    private int tunniste;
    /**
     * Etäisyys lähtösolmusta
     */
    private int etaisyysLahtoSolmusta;
    /**
     * Y-koodrinaatti
     */
    private int y;
    /**
     * X-koordinaatti
     */
    private int x;;
    /**
     * Edellinen solmu, jotta saadaan lyhin reitti tallennettua
     */
    private SolmuDijkstra prev;

    /**
     * Luodaan solmu sellaisilla spekseillä, jotka luonnin yhteydessä tiedetään.
     * @param tunniste Solmun tunnisteluku
     * @param y Y-koordinaatti
     * @param x X-koordinaatti
     */
    public SolmuDijkstra(int tunniste, int y, int x) {
        this.tunniste = tunniste;
        this.y = y;
        this.x = x;
    }

    public void setEtaisyysLahtoSolmusta(int uusiEtaisyys) {
        this.etaisyysLahtoSolmusta = uusiEtaisyys;
    }

    public int getEtaisyysLahtoSolmusta() {
        return this.etaisyysLahtoSolmusta;
    }

    public int getTunniste() {
        return this.tunniste;
    }

    @Override
    public int compareTo(SolmuDijkstra t) {
        if (this.etaisyysLahtoSolmusta > t.etaisyysLahtoSolmusta) {
            return 1;
        } else if (this.etaisyysLahtoSolmusta == t.etaisyysLahtoSolmusta) {
            return 0;
        } else {
            return -1;
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
    public void setPrev(SolmuDijkstra s) {
        this.prev = s;
    }
    
    public SolmuDijkstra getPrev() {
        return this.prev;
    }
}
