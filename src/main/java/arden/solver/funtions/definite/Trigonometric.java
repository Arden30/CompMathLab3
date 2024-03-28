package arden.solver.funtions.definite;

import arden.solver.funtions.Function;

import static java.lang.Math.*;

public class Trigonometric implements Function {
    @Override
    public String function() {
        return "sin(x)^3 * cos(x)^4";
    }

    @Override
    public double value(double x) {
        return pow(sin(x), 3) * pow(cos(x), 4);
    }

    @Override
    public double primitive(double x) {
        return 1;
    }
}
