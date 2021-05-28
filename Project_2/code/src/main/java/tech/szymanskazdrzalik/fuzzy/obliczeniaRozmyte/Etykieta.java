package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class Etykieta<T> {

    private String nazwa;
    private AbstrakcyjnyZbiorRozmyty<T> abstrakcyjnyZbiorRozmyty;

    public Etykieta(String nazwa, AbstrakcyjnyZbiorRozmyty<T> abstrakcyjnyZbiorRozmyty) {
        this.nazwa = nazwa;
        this.abstrakcyjnyZbiorRozmyty = abstrakcyjnyZbiorRozmyty;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public AbstrakcyjnyZbiorRozmyty<T> getAbstractZbiorRozmyty() {
        return abstrakcyjnyZbiorRozmyty;
    }

    public void setAbstractZbiorRozmyty(AbstrakcyjnyZbiorRozmyty<T> abstrakcyjnyZbiorRozmyty) {
        this.abstrakcyjnyZbiorRozmyty = abstrakcyjnyZbiorRozmyty;
    }
}
