package tech.szymanskazdrzalik.fuzzy.fuzzyCalculations;

public class FunkcjaGausowska implements FunkcjaPrzynaleznosci {

    double sigma;
    double h;
    double mid;

    public FunkcjaGausowska(double sigma, double h, double mid) {
        this.sigma = sigma;
        this.h = h;
        this.mid = mid;
    }

    @Override
    public double przynaleznosc(double x) {
        return h * Math.exp(- Math.pow(x - mid, 2) / (2 * Math.pow(sigma, 2)));
    }
}
