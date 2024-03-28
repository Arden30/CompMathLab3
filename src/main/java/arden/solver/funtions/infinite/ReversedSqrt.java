package arden.solver.funtions.infinite;

import arden.solver.funtions.Function;

import static java.lang.Math.sqrt;

public class ReversedSqrt implements Function {
    @Override
    public String function() {
        return "1/sqrt(x)";
    }

    @Override
    public double value(double x) {
        return 1/sqrt(x);
    }

    @Override
    public double primitive(double x) {
        return 2*sqrt(x);
    }
}
