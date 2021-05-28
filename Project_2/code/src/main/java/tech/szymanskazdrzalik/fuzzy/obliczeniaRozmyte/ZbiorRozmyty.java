package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public interface ZbiorRozmyty extends FunkcjaPrzynaleznosci {


    /**
     * Wysokość - maksymalna wartość funkcji przynależności.
     *
     * @return the wysokosc
     */
    default Double getWysokosc() {
        return 1.0;
    }


    /**
     * Nośnik - zbiór elementów, których wartość funkcji przynależności jest większa od 0.
     *
     * @param <T>             the type parameter
     * @param objectDoubleMap the object double map
     * @return the nosnik
     */
    default <T> List<T> getNosnik(Map<T, Double> objectDoubleMap) {
        return this.getPrzekrojAlfa(objectDoubleMap, 0.0);
    }

    /**
     * Przekrój alfa - zbiór elementów, których wartość funkcji przynależności jest większa od {@param alfa}.
     *
     * @param <T>             the type parameter
     * @param objectDoubleMap the object double map
     * @param alfa            the alfa
     * @return the przekroj alfa
     */
    default <T> List<T> getPrzekrojAlfa(Map<T, Double> objectDoubleMap, Double alfa) {
        List<T> list = new ArrayList<>();
        objectDoubleMap.forEach(new BiConsumer<>() {
            @Override
            public void accept(T o, Double aDouble) {
                if (ZbiorRozmyty.this.przynaleznosc(aDouble) > alfa) {
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

    /**
     * Liczba kardynalna - suma wyników funkcji przynależności dla elementów.
     *
     * @param <T>             the type parameter
     * @param objectDoubleMap the object double map
     * @return the double
     */
    default <T> Double liczbaKardynalna(Map<T, Double> objectDoubleMap) {
        final Double[] sum = {0.0};
        objectDoubleMap.forEach((t, aDouble) -> sum[0] += ZbiorRozmyty.this.przynaleznosc(aDouble));
        return sum[0];
    }

    default Double iloczynZbiorow(ZbiorRozmyty zbiorRozmyty, Double x) {
        return Math.min(this.przynaleznosc(x), zbiorRozmyty.przynaleznosc(x));
    }

    default Double sumaZbiorow(ZbiorRozmyty zbiorRozmyty, Double x) {
        return Math.max(this.przynaleznosc(x), zbiorRozmyty.przynaleznosc(x));
    }

    default Double dopelnienieZbioru(Double x) {
        return 1 - this.przynaleznosc(x);
    }
}
