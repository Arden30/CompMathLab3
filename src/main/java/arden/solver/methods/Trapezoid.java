package arden.solver.methods;

import arden.solver.funtions.Function;

public class Trapezoid implements Method {
    @Override
    public String description() {
        return "Метод трапеций";
    }

    @Override
    public int order() {
        return 3;
    }

    @Override
    public double solve(Function function, double a, double b, double accuracy, int n) {
        double h = (b - a) / n;
        double x = a;
        double res = 0;

        while (n-- > 0) {
            res += h/2 * (function.value(x) + function.value(x + h));
            x += h;
        }

        return res;
    }
}
