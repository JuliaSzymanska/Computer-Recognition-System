package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class Etykieta {

    private String nazwa;
    private AbstractZbiorRozmyty abstractZbiorRozmyty;

    public Etykieta(String nazwa, AbstractZbiorRozmyty abstractZbiorRozmyty) {
        this.nazwa = nazwa;
        this.abstractZbiorRozmyty = abstractZbiorRozmyty;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public AbstractZbiorRozmyty getAbstractZbiorRozmyty() {
        return abstractZbiorRozmyty;
    }

    public void setAbstractZbiorRozmyty(AbstractZbiorRozmyty abstractZbiorRozmyty) {
        this.abstractZbiorRozmyty = abstractZbiorRozmyty;
    }
}
