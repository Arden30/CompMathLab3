package arden.solver.methods;

import arden.solver.funtions.Function;

public interface Method {
    String description();

    double solve(Function function, double a, double b, double accuracy, int n);

    int order();
}
