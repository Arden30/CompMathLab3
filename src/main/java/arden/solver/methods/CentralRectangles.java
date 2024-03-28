package arden.solver.methods;

import arden.solver.funtions.Function;

public class CentralRectangles implements Method {
    @Override
    public String description() {
        return "Метод средних прямоугольников";
    }

    @Override
    public int order() {
        return 3;
    }

    @Override
    public double solve(Function function, double a, double b, double accuracy, int n) {
        double h = (b - a) / n;
        double x1 = a;
        double x2 = x1 + h;
        double res = 0;

        while (n-- > 0) {
            res += function.value((x1 + x2) / 2);
            x1 = x2;
            x2 = x1 + h;
        }

        return h * res;
    }
}
