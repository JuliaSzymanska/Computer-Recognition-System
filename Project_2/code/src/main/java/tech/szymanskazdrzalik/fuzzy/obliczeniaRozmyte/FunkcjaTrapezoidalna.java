package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class FunkcjaTrapezoidalna<T> extends AbstractZbiorRozmyty<T> {
    private final Double poczatek;
    private final Double poczatekWartosciMaksymalnej;
    private final Double koniecWartosciMaksymalnej;
    private final Double koniec;
    private final GetValue<T> getValue;

    public FunkcjaTrapezoidalna(Double poczatek, Double poczatekWartosciMaksymalnej, Double maxEnd, Double koniec, Double poczatekUniversum, double koniecUniversum, GetValue<T> getValue) {
        super(poczatekUniversum, koniecUniversum);
        this.getValue = getValue;
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
        if (this.getValue.getValue(t) >= poczatekWartosciMaksymalnej && this.getValue.getValue(t) <= koniecWartosciMaksymalnej) {
            return 1.0;
        }
        if (this.getValue.getValue(t) > poczatek && this.getValue.getValue(t) < poczatekWartosciMaksymalnej) {
            return (this.getValue.getValue(t) - poczatek) / (poczatekWartosciMaksymalnej - poczatek);
        }
        if (this.getValue.getValue(t) > koniecWartosciMaksymalnej && this.getValue.getValue(t) < koniec) {
            return 1 - ((this.getValue.getValue(t) - koniecWartosciMaksymalnej) / (koniec - koniecWartosciMaksymalnej));
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
        return true;
    }
}
