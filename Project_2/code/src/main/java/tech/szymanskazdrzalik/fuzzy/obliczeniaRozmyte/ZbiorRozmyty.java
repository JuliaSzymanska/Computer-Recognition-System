package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import java.util.List;
import java.util.Map;

public interface ZbiorRozmyty {
    Double getWysokosc();
    <T> List<T> getNosnik(Map<T, Double> objectDoubleMap);
    <T> List<T> getPrzekrojAlfa(Map<T, Double> objectDoubleMap, Double alfa);



}
