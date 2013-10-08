package aputyokalut;

/**
 * Solmu, joka pitää sisällään tietoa etäisyydestä alkuun, arviota etäisyydestä loppuun ja niiden yhteenlaskettua arvoa. Myös x- ja y-koordinaatit löytyvät.
 * @author Jerry
 */
public class SolmuAstar implements Comparable<SolmuAstar> {

    /**
     * Mitä laatua solmu on.
     */
    private int tunniste;
    /**
     * Etäisyys alusta.
     */
    private int etaisyysLahtoSolmusta;
    /**
     * Arvio etäisyydestä maaliin.
     */
    private int arvioEtaisyydestaLoppuSolmuun;
    /**
     * Alun ja lopun yhteenlaskettu etäisyys.
     */
    private int yhdistettyEtaisyys;
    /**
     * Y-koordinaatti
     */
    private int y;
    /**
     * X-koordinaatti
     */
    private int x;

    /**
     * Kerrotaan solmulle sen olemus ja koordinaatit
     * @param tunniste Onko solmu seinää vai polkua
     * @param y Y-koordinaatti
     * @param x X-koordinaatti
     */
    public SolmuAstar(int tunniste, int y, int x) {
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
    
    public void setArvioEtaisyydestaLoppuSolmuun(int arvio) {
        this.arvioEtaisyydestaLoppuSolmuun = arvio;
    }
    
    public int getArvioEtaisyydestaLoppuSolmuun() {
        return this.arvioEtaisyydestaLoppuSolmuun;
    }
    
    public void setYhdistettyEtaisyys() {
        this.yhdistettyEtaisyys = this.etaisyysLahtoSolmusta + this.arvioEtaisyydestaLoppuSolmuun;
    }
    
    public int getYhdistettyEtaisyys() {
        return this.yhdistettyEtaisyys;
    }

    @Override
    public int compareTo(SolmuAstar t) {
        if (this.yhdistettyEtaisyys > t.yhdistettyEtaisyys) {
            return 1;
        } else if (this.yhdistettyEtaisyys == t.yhdistettyEtaisyys) {
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
}
