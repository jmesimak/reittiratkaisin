package aputietorakenteet;

import aputyokalut.SolmuAstar;

/**
 * A*:in käyttämä minimikeko, jossa keon sisältämien solmujen avain on niiden yhteenlaskettu etäisyys lähtöruutuudusta ja arviosta etäisyydestä maaliruutuun.
 * @author Jerry
 */
public class MinimikekoAstar {

    /**
     * Solmut, jotka keosta löytyvät.
     */
    private SolmuAstar[] sisalto;
    /**
     * Keon sisältämien solmujen määrä.
     */
    private int keonKoko;

    /**
     * Luodaan taulukko, johon solmuja voidaan tallentaa ja kerrotaan keolle sen koko.
     * @param koko Luolaston pinta-ala.
     */
    public MinimikekoAstar(int koko) {
        this.sisalto = new SolmuAstar[koko + 1];
        this.keonKoko = 0;
    }

    /**
     * Heap-Insert, jossa jokaiselle lisättävälle etsitään oikea kekoehtoa rikkomaton paikka.
     * @param lisattava Lisättävä solmu.
     */
    public void lisaaKekoon(SolmuAstar lisattava) {

        if (keonKoko == sisalto.length) {
            return;
        }

        int i = this.keonKoko;
        sisalto[i] = lisattava;

        while (i > 1 && sisalto[vanhempi(i)].getYhdistettyEtaisyys() > lisattava.getYhdistettyEtaisyys()) {
            vaihda(i, vanhempi(i));
            i = vanhempi(i);
        }

        this.keonKoko++;
    }

    /**
     * Minimikeon heapify-metodi, jolla ylläpidetään kekoehtoa.
     * @param vaihdettavanIndeksi Kekoehdon mahdollisesti rikkovan solmun indeksi taulukossa.
     */
    private void heapify(int vaihdettavanIndeksi) {
        int vasen = 2 * vaihdettavanIndeksi + 1;
        int oikea = 2 * vaihdettavanIndeksi + 2;
        int pienempi;

        if (vasen >= this.keonKoko && oikea >= this.keonKoko) {
            return;
        }

        if (sisalto[vasen].getYhdistettyEtaisyys() < sisalto[oikea].getYhdistettyEtaisyys()) {
            pienempi = vasen;
        } else {
            pienempi = oikea;
        }

        if (pienempi != vaihdettavanIndeksi) {
            vaihda(vaihdettavanIndeksi, pienempi);
            heapify(pienempi);
        }
    }

    /**
     * Solmun vanhempi.
     * @param i Solmun indeksi.
     * @return Solmun vanhemman indeksi.
     */
    private int vanhempi(int i) {
        return (i - 1) / 2;
    }

    /**
     * Vaihtaa kahta solmua keskenään.
     * @param eka Ensimmäinen vaihdettava.
     * @param toka Toinen vaihdettava.
     */
    private void vaihda(int eka, int toka) {
        SolmuAstar valiaikainen = sisalto[eka];
        sisalto[eka] = sisalto[toka];
        sisalto[toka] = valiaikainen;
    }

    /**
     * Ottaa keon päälimmäisen solmun pois.
     * @return Päälimmäinen solmu.
     */
    public SolmuAstar poistaPienin() {
        if (this.keonKoko < 1) {
            return null;
        }

        SolmuAstar pienin = sisalto[0];
        sisalto[0] = sisalto[this.keonKoko - 1];
        this.keonKoko--;
        if (this.keonKoko > 0) {
            heapify(0);
        }
        return pienin;
    }

    /**
     * @return Kertoo onko keko tyhjä.
     */
    public boolean onkoTyhja() {
        if (this.keonKoko == 0) {
            return true;
        } else {
            return false;
        }
    }
}
