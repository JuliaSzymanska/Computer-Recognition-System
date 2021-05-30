package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import java.util.ArrayList;
import java.util.List;

public interface ZbiorRozmyty<T> extends FunkcjaPrzynaleznosci<T> {

    /**
     * Wysokość - maksymalna wartość funkcji przynależności.
     *
     * @return the wysokosc
     */
    default Double getWysokosc() {
        return 1.0;
    }

    default boolean jestDyskretny() {
        return true;
    }

    /**
     * Nośnik - zbiór elementów, których wartość funkcji przynależności jest większa od 0.
     *
     * @return the nosnik
     */
    default List<T> getNosnik(List<T> objectDoubleMap) {
        return this.getPrzekrojAlfa(objectDoubleMap, 0.0);
    }

    /**
     * Przekrój alfa - zbiór elementów, których wartość funkcji przynależności jest większa od {@param alfa}.
     *
     * @param alfa the alfa
     * @return the przekroj alfa
     */
    default List<T> getPrzekrojAlfa(List<T> list, Double alfa) {
        List<T> returnList = new ArrayList<>();
        list.forEach(t -> {
            if (ZbiorRozmyty.this.przynaleznosc(t) > alfa) {
                returnList.add(t);
            }
        });
        return returnList;
    }

    default Double stopienRozmycia(List<T> list) {
        return (double) (this.getNosnik(list).size()) / list.size();
    }

    /**
     * Liczba kardynalna - suma wyników funkcji przynależności dla elementów.
     *
     * @return the double
     */
    default Double liczbaKardynalna(List<T> list) {
        final Double[] sum = {0.0};
        list.forEach(t -> sum[0] += ZbiorRozmyty.this.przynaleznosc(t));
        return sum[0];
    }
}
