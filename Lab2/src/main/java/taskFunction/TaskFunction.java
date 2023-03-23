package taskFunction;

import logarithmic.CommonLogarithm;
import logarithmic.NaturalLogarithm;
import trigonometric.Cos;
import trigonometric.Csc;
import trigonometric.Sec;
import trigonometric.Sin;

import static logarithmic.CommonLogarithm.evalLog;
import static logarithmic.NaturalLogarithm.evalLn;

public class TaskFunction {
    // ((sec(x)^2 + csc(x))^6)/sin(x) x >= 0
    // (( ((log base 3 x + log base 5 x) / (ln x / log base 2 x)) - log  base 3 x) * log  base 2 x)^2 < 0

    CommonLogarithm log;
    NaturalLogarithm ln;
    Sec sec;
    Csc csc;
    Sin sin;

    public TaskFunction(){
        log = new CommonLogarithm();
        ln = new NaturalLogarithm();
        sec = new Sec();
        csc = new Csc();
        sin = new Sin();
    }

    public double evalTask(double x, double eps) {
        double res;
        if (x < 0 || x < eps) {
            res = Math.pow((Math.pow(sec.sec(x, eps), 2) + csc.csc(x, eps)), 6) / sin.sin(x, eps);
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

        Sin sin = new Sin();
        System.out.println(sin.sin(Math.PI, 1e-15));

        Cos cos  = new Cos();
        System.out.println(cos.cos(0, 1e-6));

        Sec sec = new Sec();
        System.out.println(sec.sec(0, 0.00001));

        Csc csc = new Csc();
        System.out.println(csc.csc(Math.PI / 2, 0.00001));

    }
}
