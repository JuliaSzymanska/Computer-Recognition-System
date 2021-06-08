package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte.Zmienne.PobierzWartosc;

public class FunkcjaTrapezoidalna<T> extends AbstrakcyjnyZbiorRozmyty<T> {
    private final Double poczatek;
    private final Double poczatekWartosciMaksymalnej;
    private final Double koniecWartosciMaksymalnej;
    private final Double koniec;
    private final PobierzWartosc<T> pobierzWartosc;

    public FunkcjaTrapezoidalna(Double poczatek, Double poczatekWartosciMaksymalnej, Double maxEnd, Double koniec, Double poczatekUniversum, double koniecUniversum, PobierzWartosc<T> pobierzWartosc) {
        super(poczatekUniversum, koniecUniversum);
        this.pobierzWartosc = pobierzWartosc;
        if (poczatek > poczatekWartosciMaksymalnej || poczatekWartosciMaksymalnej > maxEnd || maxEnd > koniec) {
            throw new RuntimeException();
        }
        this.poczatek = poczatek;
        this.poczatekWartosciMaksymalnej = poczatekWartosciMaksymalnej;
        this.koniecWartosciMaksymalnej = maxEnd;
        this.koniec = koniec;
    }

    public Double getPoczatek() {
        return poczatek;
    }

    public Double getPoczatekWartosciMaksymalnej() {
        return poczatekWartosciMaksymalnej;
    }

    public Double getKoniecWartosciMaksymalnej() {
        return koniecWartosciMaksymalnej;
    }

    public Double getKoniec() {
        return koniec;
    }

    @Override
    public Double przynaleznosc(T t) {
        if (this.pobierzWartosc.pobierzWartosc(t) >= poczatekWartosciMaksymalnej && this.pobierzWartosc.pobierzWartosc(t) <= koniecWartosciMaksymalnej) {
            return 1.0;
        }
        if (this.pobierzWartosc.pobierzWartosc(t) > poczatek && this.pobierzWartosc.pobierzWartosc(t) < poczatekWartosciMaksymalnej) {
            return (this.pobierzWartosc.pobierzWartosc(t) - poczatek) / (poczatekWartosciMaksymalnej - poczatek);
        }
        if (this.pobierzWartosc.pobierzWartosc(t) > koniecWartosciMaksymalnej && this.pobierzWartosc.pobierzWartosc(t) < koniec) {
            return 1 - ((this.pobierzWartosc.pobierzWartosc(t) - koniecWartosciMaksymalnej) / (koniec - koniecWartosciMaksymalnej));
        }
        return 0.0;
    }


    public boolean jestWklesly() {
        return false;
    }


    public boolean jestWypukly() {
        return true;
    }


    public boolean jestPusty() {
        return getPoczatek() > getKoniecPrzestrzeniRozwazan() || getKoniec() < getPoczatekPrzestrzeniRozwazan();
    }


    public boolean jestNormalny() {
        return getKoniecWartosciMaksymalnej() >= getPoczatekPrzestrzeniRozwazan() && getPoczatekWartosciMaksymalnej() <= getKoniecPrzestrzeniRozwazan();
    }
}
