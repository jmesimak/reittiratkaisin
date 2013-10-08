package aputyokalut;

/**
 * Muuntaa luolaston sellaiseksi, että Bellman-Ford kykenee sitä helposti käsittelemään.
 * @author Jerry
 */
public class AlustajaBellmanFord {
    
    /**
     * Solmut, jotka muodostavat luolaston.
     */
    private SolmuBellmanFord[][] solmut;
    
    /**
     * Luodaan alustaja.
     */
    public AlustajaBellmanFord() {
    }
    
    /**
     * Alustetaan luolasto niin, että sen jokainen piste saa kuvaajakseen sellaisen solmun, jota algoritmi käyttää ratkaisemista varten.
     * @param luolasto Luolasto, joka halutaan muuttaa Bellman-Fordin ratkaistavaksi.
     */
    public void alustaLuolastoSolmuiksi(int[][] luolasto) {
        this.solmut = new SolmuBellmanFord[luolasto.length][luolasto[0].length];
        
        for (int i = 0; i < luolasto.length; i++) {
            for (int j = 0; j < luolasto[0].length; j++) {
                this.solmut[i][j] = new SolmuBellmanFord(luolasto[i][j]);
                this.solmut[i][j].setEtaisyysLahtosolmusta(Integer.MAX_VALUE/2);
            }
        }
        
        // Lähtösolmun etäisyys itsestään on luonnollisesti nolla
        this.solmut[0][0].setEtaisyysLahtosolmusta(0);
        
    }
    
    public SolmuBellmanFord[][] getSolmut() {
        return this.solmut;
    }
}
