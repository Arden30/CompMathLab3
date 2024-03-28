package arden.solver.utils;

import arden.solver.Solver;
import arden.solver.methods.Method;
import arden.solver.models.Solution;
import arden.solver.models.Task;

import java.util.Scanner;

import static arden.solver.utils.PrettyPrinter.printSolution;
import static arden.solver.utils.PrettyPrinter.printString;

public class ProgramStarter {
    private final Scanner scanner = new Scanner(System.in);
    private final Reader reader = new Reader();

    public void start() {
        while (true) {
            try {
                int type = typeOfIntegral();

                switch (type) {
                    case 1 -> {
                        Task task = reader.readDefiniteIntegral();
                        Method method = task.method();

                        Solution solution = Solver.solveWithAccuracy(method, task);
                        printSolution(solution, task);
                    }
                    case 2 -> {
                        Task task = reader.readInfiniteIntegral();
                        Method method = task.method();

                        if (!Solver.checkConvergence(task)) {
                            printString("Интеграл расходится");
                            continue;
                        }

                        Solution solution = Solver.solveWithIntervals(method, task);
                        printSolution(solution, task);
                    }
                }
            } catch (Exception e) {
                PrettyPrinter.printString(e.getMessage());
                scanner.next();
            }
        }
    }

    private int typeOfIntegral() {
        while (true) {
            try {
                printString("Выберите вид интеграла: определенный (введите 1) или несобственный (введите 2)");
                int type = scanner.nextInt();

                if (type != 1 && type != 2) {
                    throw new IllegalArgumentException("Такого номера нет, попробуйте ещё раз");
                }

                return type;
            } catch (IllegalArgumentException e) {
                printString(e.getMessage());
            } catch (Exception e) {
                printString("Ошибка ввода вида интеграла, попробуйте ещё раз");
                scanner.next();
            }
        }
    }
}
