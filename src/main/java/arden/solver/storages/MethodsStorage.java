package arden.solver.storages;

import arden.solver.methods.*;

import java.util.ArrayList;
import java.util.List;

public class MethodsStorage {
    private final static List<Method> METHODS = new ArrayList<>();

    public static List<Method> getMethods() {
        setMethods();

        return METHODS;
    }

    private static void setMethods() {
        METHODS.add(new LeftRectangles());
        METHODS.add(new RightRectangles());
        METHODS.add(new CentralRectangles());
        METHODS.add(new Trapezoid());
        METHODS.add(new Simpson());
    }
}
