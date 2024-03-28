package arden.solver.funtions.definite;

import arden.solver.funtions.Function;

import static java.lang.Math.exp;
import static java.lang.Math.pow;

public class Poisson implements Function {
    @Override
    public String function() {
        return "e^(-x^2) -- интеграл Пуассона";
    }

    @Override
    public double value(double x) {
        return exp(-pow(x, 2));
    }

    @Override
    public double primitive(double x) {
        return 1;
    }
}
