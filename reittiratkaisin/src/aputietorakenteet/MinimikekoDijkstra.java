package aputietorakenteet;

import aputyokalut.SolmuDijkstra;

/**
 * Dijkstran käyttämä minimikeko, jossa alkioiden avain on niiden etäisyys
 * lähdöstä.
 *
 * @author Jerry
 */
public class MinimikekoDijkstra {

    /**
     * Solmut, jotka keosta löytyvät.
     */
    private SolmuDijkstra[] sisalto;
    /**
     * Keon sisältämien solmujen määrä.
     */
    private int keonKoko;

    /**
     * Luodaan taulukko, johon solmuja voidaan tallentaa ja kerrotaan keolle sen
     * koko.
     *
     * @param koko Luolaston pinta-ala.
     */
    public MinimikekoDijkstra(int koko) {
        this.sisalto = new SolmuDijkstra[koko + 1];
        this.keonKoko = 0;
    }

    /**
     * Heap-Insert, jossa jokaiselle lisättävälle etsitään oikea kekoehtoa
     * rikkomaton paikka.
     *
     * @param lisattava Lisättävä solmu.
     */
    public void lisaaKekoon(SolmuDijkstra lisattava) {

        if (keonKoko == sisalto.length) {
            return;
        }

        int i = this.keonKoko;
        sisalto[i] = lisattava;

        while (i > 1 && sisalto[vanhempi(i)].getEtaisyysLahtoSolmusta() > lisattava.getEtaisyysLahtoSolmusta()) {
            vaihda(i, vanhempi(i));
            i = vanhempi(i);
        }

        this.keonKoko++;
    }

    /**
     * Pienentää indeksissä olevan etäisyyttä haluttuun arvoon.
     *
     * @param indeksi Pienennettävän indeksi
     * @param arvo Haluttu arvo
     */
    public void decKey(int indeksi, int arvo) {
        if (arvo < sisalto[indeksi].getEtaisyysLahtoSolmusta()) {
            sisalto[indeksi].setEtaisyysLahtoSolmusta(arvo);
            heapify(indeksi);
        }
    }

    /**
     * Minimikeon heapify-metodi, jolla ylläpidetään kekoehtoa.
     *
     * @param vaihdettavanIndeksi Kekoehdon mahdollisesti rikkovan solmun
     * indeksi taulukossa.
     */
    private void heapify(int vaihdettavanIndeksi) {
        int vasen = 2 * vaihdettavanIndeksi + 1;
        int oikea = 2 * vaihdettavanIndeksi + 2;
        int pienempi;

        if (vasen >= this.keonKoko && oikea >= this.keonKoko) {
            return;
        }

        if (sisalto[vasen].getEtaisyysLahtoSolmusta() < sisalto[oikea].getEtaisyysLahtoSolmusta()) {
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
     *
     * @param i Solmun indeksi.
     * @return Solmun vanhemman indeksi.
     */
    private int vanhempi(int i) {
        return (i - 1) / 2;
    }

    /**
     * Vaihtaa kahta solmua keskenään.
     *
     * @param eka Ensimmäinen vaihdettava.
     * @param toka Toinen vaihdettava.
     */
    private void vaihda(int eka, int toka) {
        SolmuDijkstra valiaikainen = sisalto[eka];
        sisalto[eka] = sisalto[toka];
        sisalto[toka] = valiaikainen;
    }

    public SolmuDijkstra poistaPienin() {
        if (this.keonKoko < 1) {
            return null;
        }

        SolmuDijkstra pienin = sisalto[0];
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
