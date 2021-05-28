package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class Kwantyfikator {

    private String nazwa;
    private Boolean jestAbsolutny;
    private Etykieta etykieta;

    public Kwantyfikator(Etykieta etykieta, String nazwa, Boolean jestAbsolutny) {
        this.etykieta = etykieta;
        this.nazwa = nazwa;
        this.jestAbsolutny = jestAbsolutny;
    }

    public Etykieta getEtykieta() {
        return etykieta;
    }

    public void setEtykieta(Etykieta etykieta) {
        this.etykieta = etykieta;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Boolean getJestAbsolutny() {
        return jestAbsolutny;
    }

    public void setJestAbsolutny(Boolean jestAbsolutny) {
        this.jestAbsolutny = jestAbsolutny;
    }
}
