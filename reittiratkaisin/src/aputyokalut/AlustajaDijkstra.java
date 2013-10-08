package aputyokalut;

/**
 * Alustaa luolaston Dijkstran algoritmia varten käsiteltäväksi.
 * @author Jerry
 */
public class AlustajaDijkstra {

    /**
     * Luolasto solmuina,
     */
    private SolmuDijkstra[][] solmut;

    /**
     * Luodaan alustaja.
     */
    public AlustajaDijkstra() {
    }

    /**
     * Muunnetaan luolaston jokainen piste niin, että niiden etäisyys lähdöstä on "ääretön (MAX_INT / 2).
     * @param luolasto Luolasto kokonaislukutaulukkona 
     */
    public void alustaLuolastoSolmuiksi(int[][] luolasto) {
        this.solmut = new SolmuDijkstra[luolasto.length][luolasto[0].length];

        for (int i = 0; i < luolasto.length; i++) {
            for (int j = 0; j < luolasto[0].length; j++) {
                this.solmut[i][j] = new SolmuDijkstra(luolasto[i][j], i, j);
                this.solmut[i][j].setEtaisyysLahtoSolmusta(Integer.MAX_VALUE / 2);
            }
        }

        this.solmut[0][0].setEtaisyysLahtoSolmusta(0);
    }

    public SolmuDijkstra[][] getSolmut() {
        return this.solmut;
    }
}
