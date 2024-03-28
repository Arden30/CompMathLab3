package arden.solver.methods;

import arden.solver.funtions.Function;

public class Simpson implements Method {
    @Override
    public String description() {
        return "Метод Симпсона";
    }

    @Override
    public int order() {
        return 15;
    }

    @Override
    public double solve(Function function, double a, double b, double accuracy, int n) {
        double h = (b - a) / n;
        double x = a + h;
        double even = 0;
        double odd = 0;

        int cnt = 1;
        while (cnt < n) {
            if (cnt % 2 != 0) {
                odd += function.value(x);
            } else {
                even += function.value(x);
            }

            x += h;
            cnt++;
        }

        return h / 3 * (function.value(a) + 4 * odd + 2 * even + function.value(b));
    }
}
