package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public abstract class AbstractZbiorRozmyty<T> implements ZbiorRozmyty<T> {

    private final Double poczatekPrzestrzeniRozwazan;
    private final Double koniecPrzestrzeniRozwazan;

    public AbstractZbiorRozmyty(Double poczatekPrzestrzeniRozwarzan, Double koniecPrzestrzeniRozwarzan){
        this.poczatekPrzestrzeniRozwazan = poczatekPrzestrzeniRozwarzan;
        this.koniecPrzestrzeniRozwazan = koniecPrzestrzeniRozwarzan;
    }

    public boolean jestGesty() {
        return true;
    }

    public Double getPoczatekPrzestrzeniRozwazan() {
        return poczatekPrzestrzeniRozwazan;
    }

    public Double getKoniecPrzestrzeniRozwazan() {
        return koniecPrzestrzeniRozwazan;
    }

    public AbstractZbiorRozmyty<T> iloczynZbiorow(AbstractZbiorRozmyty<T> zbiorRozmyty) {
        return new AbstractZbiorRozmyty<T>(
                Math.min(this.poczatekPrzestrzeniRozwazan, zbiorRozmyty.poczatekPrzestrzeniRozwazan),
                Math.max(this.koniecPrzestrzeniRozwazan, zbiorRozmyty.koniecPrzestrzeniRozwazan)) {
            @Override
            public Double przynaleznosc(T t) {
                return Math.min(AbstractZbiorRozmyty.this.przynaleznosc(t), zbiorRozmyty.przynaleznosc(t));
            }
        };
    }


    public AbstractZbiorRozmyty<T> sumaZbiorow(AbstractZbiorRozmyty<T> zbiorRozmyty) {
        return new AbstractZbiorRozmyty<T>(
                Math.min(this.poczatekPrzestrzeniRozwazan, zbiorRozmyty.poczatekPrzestrzeniRozwazan),
                Math.max(this.koniecPrzestrzeniRozwazan, zbiorRozmyty.koniecPrzestrzeniRozwazan)) {
            @Override
            public Double przynaleznosc(T x) {
                return Math.max(AbstractZbiorRozmyty.this.przynaleznosc(x), zbiorRozmyty.przynaleznosc(x));
            }
        };
    }

    public AbstractZbiorRozmyty<T> dopelnienieZbioru() {
        return new AbstractZbiorRozmyty<T>(this.poczatekPrzestrzeniRozwazan, this.koniecPrzestrzeniRozwazan) {
            @Override
            public Double przynaleznosc(T x) {
                return 1 - AbstractZbiorRozmyty.this.przynaleznosc(x);
            }
        };
    }
}
