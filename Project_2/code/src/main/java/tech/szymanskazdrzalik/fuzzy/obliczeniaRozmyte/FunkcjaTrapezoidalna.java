package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class FunkcjaTrapezoidalna extends AbstractZbiorRozmyty {
    private final Double poczatek;
    private final Double poczatekWartosciMaksymalnej;
    private final Double koniecWartosciMaksymalnej;
    private final Double koniec;

    public FunkcjaTrapezoidalna(Double poczatek, Double poczatekWartosciMaksymalnej, Double maxEnd, Double koniec, Double poczatekUniversum, double koniecUniversum) {
        super(poczatekUniversum, koniecUniversum);
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
    public Double przynaleznosc(Double x) {
        if (x >= poczatekWartosciMaksymalnej && x <= koniecWartosciMaksymalnej) {
            return 1.0;
        }
        if (x > poczatek && x < poczatekWartosciMaksymalnej) {
            return (x - poczatek) / (poczatekWartosciMaksymalnej - poczatek);
        }
        if (x > koniecWartosciMaksymalnej && x < koniec) {
            return 1 - ((x - koniecWartosciMaksymalnej) / (koniec - koniecWartosciMaksymalnej));
        }
        return 0.0;
    }
}
