package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import java.util.List;

public class Utils {

    public static <T> AbstrakcyjnyZbiorRozmyty<T> iloczyn(List<Etykieta<T>> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }
        var x = list.get(0).getAbstractZbiorRozmyty();
        for (var t : list) {
            x = t.getAbstractZbiorRozmyty().iloczynZbiorow(x);
        }
        return x;
    }


    public static <T> AbstrakcyjnyZbiorRozmyty<T> suma(List<Etykieta<T>> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }
        var x = list.get(0).getAbstractZbiorRozmyty();
        for (var t : list) {
            x = t.getAbstractZbiorRozmyty().sumaZbiorow(x);
        }
        return x;
    }

}
