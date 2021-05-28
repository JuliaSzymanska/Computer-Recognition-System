package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public abstract class AbstractZbiorRozmyty implements ZbiorRozmyty {
    private Double poczatekPrzestrzeniRozwarzan;
    private Double koniecPrzestrzeniRozwarzan;

    public AbstractZbiorRozmyty(Double poczatekPrzestrzeniRozwarzan, Double koniecPrzestrzeniRozwarzan) {
        this.poczatekPrzestrzeniRozwarzan = poczatekPrzestrzeniRozwarzan;
        this.koniecPrzestrzeniRozwarzan = koniecPrzestrzeniRozwarzan;
    }

    public void setPoczatekPrzestrzeniRozwarzan(Double poczatekPrzestrzeniRozwarzan) {
        this.poczatekPrzestrzeniRozwarzan = poczatekPrzestrzeniRozwarzan;
    }

    public void setKoniecPrzestrzeniRozwarzan(Double koniecPrzestrzeniRozwarzan) {
        this.koniecPrzestrzeniRozwarzan = koniecPrzestrzeniRozwarzan;
    }

    public AbstractZbiorRozmyty() {

    }

    public Double getPoczatekPrzestrzeniRozwarzan() {
        return this.poczatekPrzestrzeniRozwarzan;
    }

    public Double getKoniecPrzestrzeniRozwarzan() {

        return this.koniecPrzestrzeniRozwarzan;
    }


    public ZbiorRozmyty iloczynZbiorow(AbstractZbiorRozmyty zbiorRozmyty) {
        return new AbstractZbiorRozmyty(
                Math.min(this.poczatekPrzestrzeniRozwarzan, zbiorRozmyty.poczatekPrzestrzeniRozwarzan),
                Math.max(this.koniecPrzestrzeniRozwarzan, zbiorRozmyty.koniecPrzestrzeniRozwarzan)) {
            @Override
            public Double przynaleznosc(Double x) {
                return Math.min(this.przynaleznosc(x), zbiorRozmyty.przynaleznosc(x));
            }
        };
    }


    public ZbiorRozmyty sumaZbiorow(AbstractZbiorRozmyty zbiorRozmyty) {
        return new AbstractZbiorRozmyty(
                Math.min(this.poczatekPrzestrzeniRozwarzan, zbiorRozmyty.poczatekPrzestrzeniRozwarzan),
                Math.max(this.koniecPrzestrzeniRozwarzan, zbiorRozmyty.koniecPrzestrzeniRozwarzan)) {
            @Override
            public Double przynaleznosc(Double x) {
                return Math.max(this.przynaleznosc(x), zbiorRozmyty.przynaleznosc(x));
            }
        };
    }

    public ZbiorRozmyty dopelnienieZbioru() {
        return new AbstractZbiorRozmyty(this.poczatekPrzestrzeniRozwarzan, this.koniecPrzestrzeniRozwarzan) {
            @Override
            public Double przynaleznosc(Double x) {
                return 1 - this.przynaleznosc(x);
            }
        };
    }
}
