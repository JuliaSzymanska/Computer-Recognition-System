package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class Lukasiewicz implements ImplikacjaRozmyta{
    @Override
    public double wartosc(double a, double b) {
        return Math.min(1, 1 - a + b);
    }
}
