package arden.solver.funtions.definite;

import arden.solver.funtions.Function;

import static java.lang.Math.pow;

public class Polynomial implements Function {
    @Override
    public String function() {
        return "-3x^3 - 5x^2 + 4x - 2";
    }

    @Override
    public double value(double x) {
        return -3 * pow (x, 3) - 5 * pow(x, 2) + 4 * x - 2;
    }

    @Override
    public double primitive(double x) {
        return 1;
    }
}
