package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public abstract class AbstractZbiorRozmyty implements ZbiorRozmyty {
    private final Double poczatekPrzestrzeniRozwarzan;
    private final Double koniecPrzestrzeniRozwazan;

    public AbstractZbiorRozmyty(Double poczatekPrzestrzeniRozwarzan, Double koniecPrzestrzeniRozwarzan) {
        this.poczatekPrzestrzeniRozwarzan = poczatekPrzestrzeniRozwarzan;
        this.koniecPrzestrzeniRozwazan = koniecPrzestrzeniRozwarzan;
    }

    public Double getPoczatekPrzestrzeniRozwazan() {
        return this.poczatekPrzestrzeniRozwarzan;
    }

    public Double getKoniecPrzestrzeniRozwazan() {

        return this.koniecPrzestrzeniRozwazan;
    }

}
