package aputyokalut;

/**
 * A*-algoritmia varten luolaston pisteet solmuiksi alustava olio.
 * @author Jerry
 */
public class AlustajaAstar {

    /**
     * Algoritmille käsiteltäväksi annettavat solmut.
     */
    private SolmuAstar[][] solmut;

    /**
     * Luodaan olio.
     */
    public AlustajaAstar() {
    }

    /**
     * Muunnetaan luolasto solmuiksi
     * @param luolasto Kokonaislukutaulukko, joka esittää luolastoa
     */
    public void alustaLuolastoSolmuiksi(int[][] luolasto) {
        this.solmut = new SolmuAstar[luolasto.length][luolasto[0].length];

        for (int i = 0; i < luolasto.length; i++) {
            for (int j = 0; j < luolasto[0].length; j++) {
                this.solmut[i][j] = new SolmuAstar(luolasto[i][j], i, j);
                this.solmut[i][j].setEtaisyysLahtoSolmusta(Integer.MAX_VALUE / 2);
                this.solmut[i][j].setArvioEtaisyydestaLoppuSolmuun(Math.abs((i-luolasto.length-1)+(j-luolasto.length-1)));
            }
        }

        this.solmut[0][0].setEtaisyysLahtoSolmusta(0);
    }

    public SolmuAstar[][] getSolmut() {
        return this.solmut;
    }
}
