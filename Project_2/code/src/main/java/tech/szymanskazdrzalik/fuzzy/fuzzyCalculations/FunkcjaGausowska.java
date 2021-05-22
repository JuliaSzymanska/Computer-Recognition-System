package tech.szymanskazdrzalik.fuzzy.fuzzyCalculations;

public class FunkcjaGausowska extends AbstractFunkcjaPrzynaleznosci implements FunkcjaPrzynaleznosci  {

    private double sigma;
    private double h;

    public double getSigma() {
        return sigma;
    }

    public double getH() {
        return h;
    }

    public double getMid() {
        return mid;
    }

    private double mid;

    public FunkcjaGausowska(double sigma, double h, double mid, double poczatekUniversum, double koniecUniversum) {
        super(poczatekUniversum, koniecUniversum);
        if (h <= 0) {
            throw  new RuntimeException();
        }
        this.sigma = sigma;
        this.h = h;
        this.mid = mid;
    }

    @Override
    public double przynaleznosc(double x) {
        return h * Math.exp(- Math.pow(x - mid, 2) / (2 * Math.pow(sigma, 2)));
    }
}
