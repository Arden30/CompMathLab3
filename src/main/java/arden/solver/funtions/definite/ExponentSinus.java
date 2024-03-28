package arden.solver.funtions.definite;

import arden.solver.funtions.Function;

import static java.lang.Math.exp;
import static java.lang.Math.sin;

public class ExponentSinus implements Function {
    @Override
    public String function() {
        return "e^x * sin(x)";
    }

    @Override
    public double value(double x) {
        return exp(x) * sin(x);
    }

    @Override
    public double primitive(double x) {
        return 1;
    }
}
