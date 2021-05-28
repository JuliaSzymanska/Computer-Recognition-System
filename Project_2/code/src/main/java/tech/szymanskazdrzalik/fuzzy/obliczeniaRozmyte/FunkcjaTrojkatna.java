package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.PobierzWartosc;

public class FunkcjaTrojkatna<T> extends FunkcjaTrapezoidalna<T> {
    public FunkcjaTrojkatna(Double poczatek, Double punktNajwyzszejWartosci, Double koniec, Double poczatekUniversum, Double koniecUniversum, PobierzWartosc<T> pobierzWartosc) {
        super(poczatek, punktNajwyzszejWartosci, punktNajwyzszejWartosci, koniec, poczatekUniversum, koniecUniversum, pobierzWartosc);
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
