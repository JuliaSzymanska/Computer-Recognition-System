package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class Kwantyfikator {

    private Boolean jestAbsolutny;
    private Etykieta<Double> etykieta;

    public Kwantyfikator(Etykieta<Double> etykieta, Boolean jestAbsolutny) {
        this.etykieta = etykieta;
        this.jestAbsolutny = jestAbsolutny;
    }

    public Etykieta<Double> getEtykieta() {
        return etykieta;
    }

    public void setEtykieta(Etykieta<Double> etykieta) {
        this.etykieta = etykieta;
    }

    public Boolean getJestAbsolutny() {
        return jestAbsolutny;
    }

    public void setJestAbsolutny(Boolean jestAbsolutny) {
        this.jestAbsolutny = jestAbsolutny;
    }
}
