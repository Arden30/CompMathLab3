package arden.solver.models;

import arden.solver.funtions.Function;
import arden.solver.methods.Method;

public record Task(Method method, Function function, double a, double b, double accuracy) {
}
