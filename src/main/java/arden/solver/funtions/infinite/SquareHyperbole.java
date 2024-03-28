package arden.solver.funtions.infinite;

import arden.solver.funtions.Function;

import static java.lang.Math.*;

public class SquareHyperbole implements Function {
    @Override
    public String function() {
        return "1/x^2";
    }

    @Override
    public double value(double x) {
        return 1 / pow(x, 2);
    }

    @Override
    public double primitive(double x) {
        return -2 / pow(x, 3);
    }
}
