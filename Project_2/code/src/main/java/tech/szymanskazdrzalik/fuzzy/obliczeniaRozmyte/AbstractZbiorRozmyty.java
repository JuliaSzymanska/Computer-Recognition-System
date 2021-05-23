package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public abstract class AbstractZbiorRozmyty implements ZbiorRozmyty {
    private final Double poczatekUniwersumDyskursu;
    private final Double koniecUniversumDyskursu;

    public AbstractZbiorRozmyty(Double poczatekUniwersumDyskursu, Double koniecUniversumDyskursu) {
        this.poczatekUniwersumDyskursu = poczatekUniwersumDyskursu;
        this.koniecUniversumDyskursu = koniecUniversumDyskursu;
    }

    public Double getPoczatekUniwersumDyskursu() {
        return this.poczatekUniwersumDyskursu;
    }

    public Double getKoniecUniversumDyskursu() {

        return this.koniecUniversumDyskursu;
    }

}
