package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public abstract class AbstractZbiorRozmyty implements ZbiorRozmyty {

    private final Double poczatekPrzestrzeniRozwazan;
    private final Double koniecPrzestrzeniRozwazan;


    public AbstractZbiorRozmyty(Double poczatekPrzestrzeniRozwarzan, Double koniecPrzestrzeniRozwarzan) {
        this.poczatekPrzestrzeniRozwazan = poczatekPrzestrzeniRozwarzan;
        this.koniecPrzestrzeniRozwazan = koniecPrzestrzeniRozwarzan;
    }


    public Double getPoczatekPrzestrzeniRozwazan() {
        return poczatekPrzestrzeniRozwazan;
    }

    public Double getKoniecPrzestrzeniRozwazan() {
        return koniecPrzestrzeniRozwazan;
    }

    public ZbiorRozmyty iloczynZbiorow(AbstractZbiorRozmyty zbiorRozmyty) {
        return new AbstractZbiorRozmyty(
                Math.min(this.poczatekPrzestrzeniRozwazan, zbiorRozmyty.poczatekPrzestrzeniRozwazan),
                Math.max(this.koniecPrzestrzeniRozwazan, zbiorRozmyty.koniecPrzestrzeniRozwazan)) {
            @Override
            public Double przynaleznosc(Double x) {
                return Math.min(this.przynaleznosc(x), zbiorRozmyty.przynaleznosc(x));
            }
        };
    }


    public ZbiorRozmyty sumaZbiorow(AbstractZbiorRozmyty zbiorRozmyty) {
        return new AbstractZbiorRozmyty(
                Math.min(this.poczatekPrzestrzeniRozwazan, zbiorRozmyty.poczatekPrzestrzeniRozwazan),
                Math.max(this.koniecPrzestrzeniRozwazan, zbiorRozmyty.koniecPrzestrzeniRozwazan)) {
            @Override
            public Double przynaleznosc(Double x) {
                return Math.max(this.przynaleznosc(x), zbiorRozmyty.przynaleznosc(x));
            }
        };
    }

    public ZbiorRozmyty dopelnienieZbioru() {
        return new AbstractZbiorRozmyty(this.poczatekPrzestrzeniRozwazan, this.koniecPrzestrzeniRozwazan) {
            @Override
            public Double przynaleznosc(Double x) {
                return 1 - this.przynaleznosc(x);
            }
        };
    }
}
