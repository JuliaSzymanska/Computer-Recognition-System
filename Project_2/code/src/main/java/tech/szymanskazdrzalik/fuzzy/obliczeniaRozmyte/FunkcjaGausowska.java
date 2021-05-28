package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public  class FunkcjaGausowska<T> extends AbstractZbiorRozmyty<T>  {

    private final Double sigma;
    private final Double wysokosc;
    private final Double srodek;
    private final GetValue<T> getValue;

    public FunkcjaGausowska(Double sigma, Double wysokosc, Double srodek, Double poczatekUniversum, Double koniecUniversum, GetValue<T> getValue) {
        super(poczatekUniversum, koniecUniversum);
        if (wysokosc <= 0) {
            throw new RuntimeException();
        }
        this.sigma = sigma;
        this.wysokosc = wysokosc;
        this.srodek = srodek;
        this.getValue = getValue;
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
        return wysokosc * Math.exp(-Math.pow(getValue.getValue(x) - srodek, 2) / (2 * Math.pow(sigma, 2)));
    }
}
