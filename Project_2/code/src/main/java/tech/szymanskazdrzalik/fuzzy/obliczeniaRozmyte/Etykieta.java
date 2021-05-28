package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class Etykieta {

    private String nazwa;
    private AbstrakcyjnyZbiorRozmyty abstrakcyjnyZbiorRozmyty;

    public Etykieta(String nazwa, AbstrakcyjnyZbiorRozmyty abstrakcyjnyZbiorRozmyty) {
        this.nazwa = nazwa;
        this.abstrakcyjnyZbiorRozmyty = abstrakcyjnyZbiorRozmyty;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public AbstrakcyjnyZbiorRozmyty getAbstractZbiorRozmyty() {
        return abstrakcyjnyZbiorRozmyty;
    }

    public void setAbstractZbiorRozmyty(AbstrakcyjnyZbiorRozmyty abstrakcyjnyZbiorRozmyty) {
        this.abstrakcyjnyZbiorRozmyty = abstrakcyjnyZbiorRozmyty;
    }
}
