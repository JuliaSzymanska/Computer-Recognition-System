package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class FunkcjaTrojkatna extends FunkcjaTrapezoidalna {
    public FunkcjaTrojkatna(Double poczatek, Double punktNajwyzszejWartosci, Double koniec, Double poczatekUniversum, Double koniecUniversum) {
        super(poczatek, punktNajwyzszejWartosci, punktNajwyzszejWartosci, koniec, poczatekUniversum, koniecUniversum);
    }


    public boolean jestWklesly() {
        return false;
    }


    public boolean jestWypukly() {
        return true;
    }


    public boolean jestPusty() {
        return super.jestPusty();
    }


    public boolean jestNormalny() {
        return super.jestNormalny();
    }
}
