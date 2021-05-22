package tech.szymanskazdrzalik.fuzzy.fuzzyCalculations;

public abstract class AbstractFunkcjaPrzynaleznosci {
    private Double poczatekUniwersumDyskursu;
    private Double koniecUniversumDyskursu;

    public Double getPoczatekUniwersumDyskursu() {
        return poczatekUniwersumDyskursu;
    }

    public Double getKoniecUniversumDyskursu() {
        return koniecUniversumDyskursu;
    }

    public AbstractFunkcjaPrzynaleznosci(Double poczatekUniwersumDyskursu, Double koniecUniversumDyskursu) {
        this.poczatekUniwersumDyskursu = poczatekUniwersumDyskursu;
        this.koniecUniversumDyskursu = koniecUniversumDyskursu;
    }
}
