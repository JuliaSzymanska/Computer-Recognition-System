package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class FunkcjaGausowska extends AbstractZbiorRozmyty  {

    private final Double sigma;
    private final Double wysokosc;
    private final Double srodek;

    public FunkcjaGausowska(Double sigma, Double wysokosc, Double srodek, Double poczatekUniversum, Double koniecUniversum) {
        super(poczatekUniversum, koniecUniversum);
        if (wysokosc <= 0) {
            throw new RuntimeException();
        }
        this.sigma = sigma;
        this.wysokosc = wysokosc;
        this.srodek = srodek;
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
    public Double przynaleznosc(Double x) {
        return wysokosc * Math.exp(-Math.pow(x - srodek, 2) / (2 * Math.pow(sigma, 2)));
    }
}
