package tech.szymanskazdrzalik.fuzzy.fuzzyCalculations;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ZbiorRozmyty {
    Double getWysokosc();
    <T> List<T> getNosnik(Map<T, Double> objectDoubleMap);
    <T> List<T> getPrzekrojAlfa(Map<T, Double> objectDoubleMap, Double alfa);



}
