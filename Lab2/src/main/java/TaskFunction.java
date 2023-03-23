import logarithmic.CommonLogarithm;
import logarithmic.NaturalLogarithm;
import trigonometric.Cos;
import trigonometric.Sin;

import java.util.Scanner;

public class TaskFunction {
    public static void main (String[] args){
        System.out.println("lab 2");
        NaturalLogarithm ln = new NaturalLogarithm();
        System.out.println(ln.series(1.9, 1e-6));

        CommonLogarithm log = new CommonLogarithm();
        System.out.println(log.eval(0.3, 1.3, 1e-6));

        Sin sin = new Sin();
        System.out.println(sin.sin(Math.PI, 1e-6));

        Cos cos = new Cos();
        System.out.println(cos.cos(Math.PI, 1e-6));
    }
}
