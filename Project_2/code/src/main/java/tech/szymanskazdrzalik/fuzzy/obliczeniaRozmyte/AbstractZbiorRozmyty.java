package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public abstract class AbstractZbiorRozmyty implements ZbiorRozmyty {
    private final Double poczatekPrzestrzeniRozwarzan;
    private final Double koniecPrzestrzeniRozwarzan;

    public AbstractZbiorRozmyty(Double poczatekPrzestrzeniRozwarzan, Double koniecPrzestrzeniRozwarzan) {
        this.poczatekPrzestrzeniRozwarzan = poczatekPrzestrzeniRozwarzan;
        this.koniecPrzestrzeniRozwarzan = koniecPrzestrzeniRozwarzan;
    }

    public Double getPoczatekPrzestrzeniRozwarzan() {
        return this.poczatekPrzestrzeniRozwarzan;
    }

    public Double getKoniecPrzestrzeniRozwarzan() {

        return this.koniecPrzestrzeniRozwarzan;
    }

}
