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
        return poczatekUniwersumDyskursu;
    }

    public Double getKoniecUniversumDyskursu() {
        return koniecUniversumDyskursu;
    }

    @Override
    public Double getWysokosc() {
        return 1.0;
    }

    @Override
    public <T> Double liczbaKardynalna(Map<T, Double> objectDoubleMap) {
        final Double[] sum = {0.0};
        objectDoubleMap.forEach((t, aDouble) -> sum[0] += AbstractZbiorRozmyty.this.przynaleznosc(aDouble));
        return sum[0];
    }

    @Override
    public <T> List<T> getNosnik(Map<T, Double> objectDoubleMap) {
        return this.getPrzekrojAlfa(objectDoubleMap, 0.0);
    }

    @Override
    public Double iloczynZbiorow(ZbiorRozmyty zbiorRozmyty, Double x) {
        return Math.min(this.przynaleznosc(x), zbiorRozmyty.przynaleznosc(x));
    }

    @Override
    public Double sumaZbiorow(ZbiorRozmyty zbiorRozmyty, Double x) {
        return Math.max(this.przynaleznosc(x), zbiorRozmyty.przynaleznosc(x));
    }

    @Override
    public Double dopelnienieZbioru(Double x) {
        return 1 - this.przynaleznosc(x);
    }

    @Override
    public <T> List<T> getPrzekrojAlfa(Map<T, Double> objectDoubleMap, Double alfa) {
        List<T> list = new ArrayList<>();
        objectDoubleMap.forEach(new BiConsumer<>() {
            @Override
            public void accept(T o, Double aDouble) {
                if (AbstractZbiorRozmyty.this.przynaleznosc(aDouble) > alfa) {
                    list.add(o);
                }
            }

            @Override
            public BiConsumer<T, Double> andThen(BiConsumer<? super T, ? super Double> after) {
                return BiConsumer.super.andThen(after);
            }
        });
        return list;
    }
}
