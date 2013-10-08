package luolasto;

import java.util.Random;

/**
 * Luolastogeneraattorin tarkoituksena on luoda erikokoisia luolastoja
 * algoritmien ratkaistavaksi. Luolaston sisäänkäynti on vasemmassa yläkulmassa
 * ja uloskäynti taas oikeassa alakulmassa. Luolasto esitetään
 * kokonaislukutaulukkona, jossa numero 1 esittää polkua ja numero 0 seinää.
 *
 * @author Jerry
 */
public class LuolastoGeneraattori {

    /**
     * LuolastoGeneraattorin generoima ratkaistava luolasto.
     */
    private int[][] luolasto;
    /**
     * Satunnaislukuja generoinnin käyttöön puskeva olio.
     */
    private Random r;

    /**
     * Alusteaan satunnaislukugeneraattori myöhempää käyttöä varten.
     */
    public LuolastoGeneraattori() {
        r = new Random();
    }

    /**
     * Metodi generoi sellaisen luolaston, joka on heti ratkaisukelpoinen.
     * Generoidut luolastot paranaevat koon kasvaessa, jollon variaatiota syntyy
     * enemmän.
     *
     * @param sivunPituus   Luolaston sivun pituus
     */
    public void generoiLuolasto(int sivunPituus) {

        this.luolasto = new int[sivunPituus][sivunPituus];

        this.luolasto[0][0] = 1;
        int yAkseli = 0;
        int xAkseli = 0;

        // Generoidaan sellainen luolasto, jossa [0][0] on yhteydessä lukujen 1 kautta taulukon viimeiseen alkioon.
        while (this.luolasto[sivunPituus - 1][sivunPituus - 1] != 1) {
            double luku = r.nextDouble();
            if (luku < 0.25) {
                if (yAkseli - 1 >= 0) {
                    this.luolasto[yAkseli - 1][xAkseli] = 1;
                    yAkseli--;
                }
            } else if (luku < 0.5) {
                if (yAkseli + 1 <= sivunPituus - 1) {
                    this.luolasto[yAkseli + 1][xAkseli] = 1;
                    yAkseli++;
                }
            } else if (luku < 0.75) {
                if (xAkseli - 1 >= 0) {
                    this.luolasto[yAkseli][xAkseli - 1] = 1;
                    xAkseli--;
                }
            } else {
                if (xAkseli + 1 <= sivunPituus - 1) {
                    this.luolasto[yAkseli][xAkseli + 1] = 1;
                    xAkseli++;
                }
            }
        }

        // Täytetään loppuosa taulukosta nollilla;
        for (int i = 0; i < luolasto.length; i++) {
            for (int j = 0; j < luolasto[0].length; j++) {
                double luku = r.nextDouble();
                if (luolasto[i][j] != 1) {
                    luolasto[i][j] = 0;
                }
            }
        }

    }

    /**
     * Tulostetaan luolasto ykkösinä ja nollina.
     */
    public void tulostaLuolasto() {
        for (int i = 0; i < luolasto.length; i++) {
            for (int j = 0; j < luolasto[0].length; j++) {
                System.out.print(luolasto[i][j]);
            }
            System.out.println("");
        }
    }

    /**
     * Standardigetteri.
     * @return Palauttaa luolaston kokonaislukutaulukkona.
     */
    public int[][] getLuolasto() {
        return this.luolasto;
    }
}
