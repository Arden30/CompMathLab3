package arden.solver.utils;

import arden.solver.funtions.Function;
import arden.solver.storages.FunctionStorage;
import arden.solver.methods.Method;
import arden.solver.storages.MethodsStorage;
import arden.solver.models.Task;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static arden.solver.utils.PrettyPrinter.*;

public class Reader {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Function> definiteFunctions = FunctionStorage.getDefiniteFunctions();
    private final List<Function> infiniteFunctions = FunctionStorage.getInfiniteFunctions();
    private final List<Method> methods = MethodsStorage.getMethods();

    public Task readInfiniteIntegral() {
        Function function = readInfiniteFunction();
        Method method = readMethod();
        double a = readLowerBoundary();
        double b = readUpperBoundary(a);
        double accuracy = readAccuracy();

        return new Task(method, function, a, b, accuracy);
    }

    private Function readInfiniteFunction() {
        while (true) {
            try {
                printFunctions(infiniteFunctions);

                return infiniteFunctions.get(scanner.nextInt() - 1);
            } catch (InputMismatchException e) {
                printString("Ошибка ввода номера функции, попробуйте ещё раз");
                scanner.next();
            } catch (IndexOutOfBoundsException e) {
                printString("Такого номера нет, попробуйте ещё раз");
            }
        }
    }

    public Task readDefiniteIntegral() {
        Function function = readDefiniteFunction();
        Method method = readMethod();
        double a = readLowerBoundary();
        double b = readUpperBoundary(a);
        double accuracy = readAccuracy();

        return new Task(method, function, a, b, accuracy);
    }

    private Function readDefiniteFunction() {
        while (true) {
            try {
                printFunctions(definiteFunctions);

                return definiteFunctions.get(scanner.nextInt() - 1);
            } catch (InputMismatchException e) {
                printString("Ошибка ввода номера функции, попробуйте ещё раз");
                scanner.next();
            } catch (IndexOutOfBoundsException e) {
                printString("Такого номера нет, попробуйте ещё раз");
            }
        }
    }

    private Method readMethod() {
        while (true) {
            try {
                printMethods(methods);

                return methods.get(scanner.nextInt() - 1);
            } catch (InputMismatchException e) {
                printString("Ошибка ввода номера метода, попробуйте ещё раз");
                scanner.next();
            } catch (IndexOutOfBoundsException e) {
                printString("Такого номера нет, попробуйте ещё раз");
            }
        }
    }

    private double readLowerBoundary() {
        while (true) {
            try {
                printString("Введите нижнюю границу a:");

                return scanner.nextDouble();
            } catch (Exception e) {
                printString("Ошибка ввода границы a, попробуйте ещё раз");
                scanner.next();
            }
        }
    }

    private double readUpperBoundary(double a) {
        while (true) {
            try {
                printString("Введите верхнюю границу b:");
                double b = scanner.nextDouble();
                if (a >= b) {
                    printString("Граница b должна быть больше границы a, введите ещё раз");
                } else {
                    return b;
                }
            } catch (Exception e) {
                printString("Ошибка ввода границы b, попробуйте ещё раз");
                scanner.next();
            }
        }
    }

    private double readAccuracy() {
        while (true) {
            try {
                printString("Введите точность: ");
                double accuracy = scanner.nextDouble();
                if (accuracy <= 0) {
                    printString("Точность должна быть неотрицательным числом");
                } else {
                    return accuracy;
                }
            } catch (Exception e) {
                printString("Ошибка ввода точности, попробуйте ещё раз");
                scanner.next();
            }
        }
    }
}
