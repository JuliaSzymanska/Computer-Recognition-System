package tech.szymanskazdrzalik.fuzzy.obliczeniaRozmyte;

public class Reichenbach implements ImplikacjaRozmyta {
    @Override
    public double wartosc(double a, double b) {
        return 1 - a + a * b;
    }
}
