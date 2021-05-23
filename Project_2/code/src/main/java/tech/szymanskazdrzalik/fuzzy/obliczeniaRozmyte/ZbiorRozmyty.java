package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

import java.util.List;
import java.util.Map;

public interface ZbiorRozmyty extends FunkcjaPrzynaleznosci  {
    Double getWysokosc();
    <T> List<T> getNosnik(Map<T, Double> objectDoubleMap);
    <T> List<T> getPrzekrojAlfa(Map<T, Double> objectDoubleMap, Double alfa);
    <T> Double liczbaKardynalna(Map<T, Double> objectDoubleMap);
    Double iloczynZbiorow(ZbiorRozmyty zbiorRozmyty, Double x);
    Double sumaZbiorow(ZbiorRozmyty zbiorRozmyty, Double x);
    Double dopelnienieZbioru(Double x);



}
