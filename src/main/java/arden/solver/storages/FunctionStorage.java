package arden.solver.storages;

import arden.solver.funtions.Function;
import arden.solver.funtions.definite.*;
import arden.solver.funtions.infinite.ReversedCube;
import arden.solver.funtions.infinite.SquareHyperbole;
import arden.solver.funtions.infinite.ReversedSqrt;

import java.util.ArrayList;
import java.util.List;

public class FunctionStorage {
    private final static List<Function> DEFINITE_FUNCTIONS = new ArrayList<>();
    private final static List<Function> INFINITE_FUNCTIONS = new ArrayList<>();

    public static List<Function> getDefiniteFunctions() {
        setDefiniteFunctions();

        return DEFINITE_FUNCTIONS;
    }

    private static void setDefiniteFunctions() {
        DEFINITE_FUNCTIONS.add(new Polynomial());
        DEFINITE_FUNCTIONS.add(new Trigonometric());
        DEFINITE_FUNCTIONS.add(new ExponentSinus());
        DEFINITE_FUNCTIONS.add(new Fresnel());
        DEFINITE_FUNCTIONS.add(new Poisson());
    }

    public static List<Function> getInfiniteFunctions() {
        setInfiniteFunctions();

        return INFINITE_FUNCTIONS;
    }

    private static void setInfiniteFunctions() {
        INFINITE_FUNCTIONS.add(new SquareHyperbole());
        INFINITE_FUNCTIONS.add(new ReversedSqrt());
        INFINITE_FUNCTIONS.add(new ReversedCube());
    }
}
