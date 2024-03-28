package arden.solver.utils;

import arden.solver.funtions.Function;
import arden.solver.methods.Method;
import arden.solver.models.Solution;
import arden.solver.models.Task;

import java.util.List;

public class PrettyPrinter {
    public static void printString(String s) {
        System.out.println(s);
    }

    public static void printFunctions(List<Function> list) {
        printString("Выберите одну из функций для численного интегрирования (введите её номер):");
        for (int i = 0; i < list.size(); i++) {
            printString(i + 1 + ": " + list.get(i).function());
        }
    }

    public static void printMethods(List<Method> list) {
        printString("Выберите один из методов численного интегрирования (введите его номер):");
        for (int i = 0; i < list.size(); i++) {
            printString(i + 1 + ": " + list.get(i).description());
        }
    }

    public static void printSolution(Solution solution, Task task) {
        int decimalPlaces = 0;
        double accuracy = task.accuracy();

        while (accuracy < 1) {
            accuracy *= 10;
            decimalPlaces++;
        }

        printString("Значение интеграла: " + String.format("%." + decimalPlaces + "f", solution.result()));
        printString("Число разбиений: " + solution.n());
    }
}
