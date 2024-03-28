package arden.solver;

import arden.solver.methods.Method;
import arden.solver.models.Interval;
import arden.solver.models.Solution;
import arden.solver.models.Task;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Solver {
    private final static double eps = 0.000001;
    public static Solution solveWithAccuracy(Method method, Task task) {
        int n = 4;
        double i0 = method.solve(task.function(), task.a(), task.b(), task.accuracy(), n);
        double i1 = 0;
        do {
            if (n != 4) {
                i0 = i1;
            }
            n *= 2;
            i1 = method.solve(task.function(), task.a(), task.b(), task.accuracy(), n);
        } while (abs(i0 - i1) / method.order() > task.accuracy());

        return new Solution(i1, n);
    }

    public static boolean hasGap(Task task, double x) {
        try {
            return abs(task.function().value(x)) > 1000000;
        } catch (ArithmeticException e) {
            return true;
        }
    }

    public static boolean checkConvergence(Task task) {
        double step = (task.b() - task.a()) / 10000;

        try {
            double a = task.function().primitive(task.a());
            double b = task.function().primitive(task.b());
            if (Double.isNaN(a) || Double.isNaN(b) || Double.isInfinite(a) || Double.isInfinite(b)) {
                return false;
            }
        } catch (ArithmeticException e) {
            return false;
        }

        for (double i = task.a(); i <= task.b(); i += step) {
            if (abs(task.function().primitive(i)) > 10000000) {
                return false;
            }
        }

        return true;
    }
    public static Interval findInterval(Task task) {
        double newA = task.a();
        double newB = task.b();
        List<Double> gaps = new ArrayList<>();

        double step = (task.b() - task.a()) / 100000;

        if(hasGap(task, task.a())) {
            newA += eps;
        }

        if (hasGap(task, task.b())) {
            newB -= eps;
        }

        for (double i = task.a() + eps; i < task.b(); i += step) {
            if (hasGap(task, i)) {
                gaps.add(i);
            }
        }
        return new Interval(newA, newB, gaps);
    }

    public static Solution solveWithIntervals(Method method, Task task) {
        Interval interval = findInterval(task);
        double res = 0;
        double prev = 0;
        List<Integer> nValues = new ArrayList<>();
        if (interval.gaps().isEmpty()) {
            Task newTask = new Task(method, task.function(), interval.a(), interval.b(), task.accuracy());

            return solveWithAccuracy(method, newTask);
        } else {
            for (double c: interval.gaps()) {
                double a = interval.a() < c ? interval.a(): prev;
                double b = c;

                Task newTask = new Task(method, task.function(), a, b, task.accuracy());
                Solution solution = solveWithAccuracy(method, newTask);

                res += solution.result();
                nValues.add(solution.n());

                prev = c;
            }
            Task newTask = new Task(method, task.function(), interval.gaps().get(interval.gaps().size() - 1), task.b(), task.accuracy());
            Solution solution = solveWithAccuracy(method, newTask);

            res += solution.result();
            nValues.add(solution.n());

            return new Solution(res, nValues.stream().max(Integer::compareTo).get());
        }
    }
}
