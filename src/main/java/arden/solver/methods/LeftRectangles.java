package arden.solver.methods;

import arden.solver.funtions.Function;

public class LeftRectangles implements Method {
    @Override
    public String description() {
        return "Метод левых прямоугольников";
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
            res += h * function.value(x);
            x += h;
        }

        return res;
    }
}
