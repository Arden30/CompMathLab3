package arden.solver.funtions.infinite;

import arden.solver.funtions.Function;

import static java.lang.Math.*;

public class SquareRoot implements Function {
    @Override
    public String function() {
        return "1/sqrt(2x-x^2)";
    }

    @Override
    public double value(double x) {
        return 1 / sqrt(2*x - pow(x, 2));
    }

    @Override
    public double primitive(double x) {
        return asin(x-1);
    }
}
