package arden.solver.funtions.definite;

import arden.solver.funtions.Function;

import static java.lang.Math.pow;
import static java.lang.Math.sin;

public class Fresnel implements Function {
    @Override
    public String function() {
        return "sin(x^2) -- интеграл Френеля";
    }

    @Override
    public double value(double x) {
        return sin(pow(x, 2));
    }

    @Override
    public double primitive(double x) {
        return 1;
    }
}
