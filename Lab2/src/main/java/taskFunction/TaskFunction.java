package taskFunction;

import static logarithmic.CommonLogarithm.evalLog;
import static logarithmic.NaturalLogarithm.evalLn;
import static trigonometric.Cos.evalCos;
import static trigonometric.Csc.evalCsc;
import static trigonometric.Sec.evalSec;
import static trigonometric.Sin.evalSin;

public class TaskFunction {
    // ((sec(x)^2 + csc(x))^6)/sin(x) x >= 0
    // (( ((log base 3 x + log base 5 x) / (ln x / log base 2 x)) - log  base 3 x) * log  base 2 x)^2 < 0
    public static double evalTask(double x, double eps) {
        double res;
        if (x < 0 || x < eps) {
            res = Math.pow((Math.pow(evalSec(x, eps), 2) + evalCsc(x, eps)), 6) / evalSin(x, eps);
        } else {
            res = Math.pow(
                    ((evalLog(3, x, eps) + evalLog(5, x, eps)) * evalLog(2, x, eps) / evalLn(x, eps) - evalLog(2, x, eps)) * evalLog(2, x, eps)
                    , 2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("lab 2");

        System.out.println(evalLog(2, 8, 1e-6));

        System.out.println(evalSin(Math.PI, 1e-15));

        System.out.println(evalCos(0, 1e-6));

        System.out.println(evalSec(0, 0.00001));

        System.out.println(evalCsc(Math.PI / 2, 0.00001));

    }
}
