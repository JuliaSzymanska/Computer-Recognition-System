package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public abstract class AbstrakcyjnyZbiorRozmyty<T> implements ZbiorRozmyty<T> {

    private final Double poczatekPrzestrzeniRozwazan;
    private final Double koniecPrzestrzeniRozwazan;

    public AbstrakcyjnyZbiorRozmyty(Double poczatekPrzestrzeniRozwarzan, Double koniecPrzestrzeniRozwarzan){
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

    public AbstrakcyjnyZbiorRozmyty<T> iloczynZbiorow(AbstrakcyjnyZbiorRozmyty<T> zbiorRozmyty) {
        return new AbstrakcyjnyZbiorRozmyty<T>(
                Math.min(this.poczatekPrzestrzeniRozwazan, zbiorRozmyty.poczatekPrzestrzeniRozwazan),
                Math.max(this.koniecPrzestrzeniRozwazan, zbiorRozmyty.koniecPrzestrzeniRozwazan)) {
            @Override
            public Double przynaleznosc(T t) {
                return Math.min(AbstrakcyjnyZbiorRozmyty.this.przynaleznosc(t), zbiorRozmyty.przynaleznosc(t));
            }
        };
    }


    public AbstrakcyjnyZbiorRozmyty<T> sumaZbiorow(AbstrakcyjnyZbiorRozmyty<T> zbiorRozmyty) {
        return new AbstrakcyjnyZbiorRozmyty<T>(
                Math.min(this.poczatekPrzestrzeniRozwazan, zbiorRozmyty.poczatekPrzestrzeniRozwazan),
                Math.max(this.koniecPrzestrzeniRozwazan, zbiorRozmyty.koniecPrzestrzeniRozwazan)) {
            @Override
            public Double przynaleznosc(T x) {
                return Math.max(AbstrakcyjnyZbiorRozmyty.this.przynaleznosc(x), zbiorRozmyty.przynaleznosc(x));
            }
        };
    }

    public AbstrakcyjnyZbiorRozmyty<T> dopelnienieZbioru() {
        return new AbstrakcyjnyZbiorRozmyty<T>(this.poczatekPrzestrzeniRozwazan, this.koniecPrzestrzeniRozwazan) {
            @Override
            public Double przynaleznosc(T x) {
                return 1 - AbstrakcyjnyZbiorRozmyty.this.przynaleznosc(x);
            }
        };
    }
}
