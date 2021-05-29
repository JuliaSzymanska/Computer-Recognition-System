package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.PobierzWartosc;

public class FunkcjaGausowska<T> extends AbstrakcyjnyZbiorRozmyty<T> {

    private final Double sigma;
    private final Double wysokosc;
    private final Double srodek;
    private final PobierzWartosc<T> pobierzWartosc;

    public FunkcjaGausowska(Double sigma, Double wysokosc, Double srodek, Double poczatekUniversum, Double koniecUniversum, PobierzWartosc<T> pobierzWartosc) {
        super(poczatekUniversum, koniecUniversum);
        if (wysokosc <= 0) {
            throw new RuntimeException();
        }
        this.sigma = sigma;
        this.wysokosc = wysokosc;
        this.srodek = srodek;
        this.pobierzWartosc = pobierzWartosc;
    }


    public boolean jestWklesly() {
        return false;
    }


    public boolean jestWypukly() {
        return true;
    }


    public boolean jestPusty() {
        return false;
    }


    public boolean jestNormalny() {
        return this.wysokosc.equals(1.0);
    }

    public Double getSigma() {
        return sigma;
    }

    @Override
    public Double getWysokosc() {
        return wysokosc;
    }

    public Double getSrodek() {
        return srodek;
    }

    @Override
    public Double przynaleznosc(T x) {
        System.out.println("wartosc: " + pobierzWartosc.pobierzWartosc(x));
        System.out.println("wartosc - srodek: " + ((double) pobierzWartosc.pobierzWartosc(x) - srodek));
        System.out.println("potega: " + (-Math.pow(pobierzWartosc.pobierzWartosc(x) - srodek, 2)));
        System.out.println("pow sigmy: " + (2 * Math.pow(sigma, 2)));
        System.out.println("exp: " + Math.exp(-Math.pow(pobierzWartosc.pobierzWartosc(x) - srodek, 2) / (2 * Math.pow(sigma, 2))));
        System.out.println("wysokosc: " + wysokosc);
        System.out.println("wynik: " + wysokosc * Math.exp(-Math.pow(pobierzWartosc.pobierzWartosc(x) - srodek, 2) / (2 * Math.pow(sigma, 2))));

        return wysokosc * Math.exp(-Math.pow(pobierzWartosc.pobierzWartosc(x) - srodek, 2) / (2 * Math.pow(sigma, 2)));
    }
}
