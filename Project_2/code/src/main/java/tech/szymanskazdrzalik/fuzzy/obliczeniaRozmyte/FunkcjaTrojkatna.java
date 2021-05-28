package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class FunkcjaTrojkatna<T> extends FunkcjaTrapezoidalna<T> {
    public FunkcjaTrojkatna(Double poczatek, Double punktNajwyzszejWartosci, Double koniec, Double poczatekUniversum, Double koniecUniversum, GetValue<T> getValue) {
        super(poczatek, punktNajwyzszejWartosci, punktNajwyzszejWartosci, koniec, poczatekUniversum, koniecUniversum, getValue);
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
