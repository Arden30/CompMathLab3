package arden.solver.funtions.infinite;

import arden.solver.funtions.Function;

import static java.lang.Math.*;

public class ReversedCube implements Function {
    @Override
    public String function() {
        return "1/(x-1)^(1/3)";
    }

    @Override
    public double value(double x) {
        return 1 / cbrt(x - 1);
    }

    @Override
    public double primitive(double x) {
        return 3 * cbrt(pow(x-1, 2)) / 2;
    }
}
