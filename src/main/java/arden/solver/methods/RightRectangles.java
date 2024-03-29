package arden.solver.methods;

import arden.solver.funtions.Function;

public class RightRectangles implements Method {
    @Override
    public String description() {
        return "Метод правых прямоугольников";
    }

    @Override
    public int order() {
        return 1;
    }

    @Override
    public double solve(Function function, double a, double b, double accuracy, int n) {
        double h = (b - a) / n;
        double x = a + h;
        double res = 0;

        while (n-- > 0) {
            res += h * function.value(x);
            x += h;
        }

        return res;
    }
}
