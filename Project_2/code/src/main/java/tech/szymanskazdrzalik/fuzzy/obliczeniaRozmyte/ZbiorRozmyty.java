package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public interface ZbiorRozmyty extends FunkcjaPrzynaleznosci  {
    default Double getWysokosc() {
        return 1.0;
    }
    default <T> List<T> getNosnik(Map<T, Double> objectDoubleMap) {
        return this.getPrzekrojAlfa(objectDoubleMap, 0.0);
    }

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
    default <T> Double liczbaKardynalna(Map<T, Double> objectDoubleMap) {
        final Double[] sum = {0.0};
        objectDoubleMap.forEach((t, aDouble) -> sum[0] += ZbiorRozmyty.this.przynaleznosc(aDouble));
        return sum[0];
    }


}
