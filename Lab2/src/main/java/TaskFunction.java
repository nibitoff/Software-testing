import logarithmic.CommonLogarithm;
import logarithmic.NaturalLogarithm;
import trigonometric.Cos;
import trigonometric.Csc;
import trigonometric.Sec;
import trigonometric.Sin;

import java.util.Scanner;

public class TaskFunction {
    public static void main (String[] args){
        System.out.println("lab 2");
        Scanner s = new Scanner(System.in);
//        float f = s.nextFloat();
//        NaturalLogarithm ln = new NaturalLogarithm();
//        System.out.println(ln.series(f, 1e-6));

        CommonLogarithm log = new CommonLogarithm();
        System.out.println(log.eval(0.3, 1.3, 1e-6));

        Sin sin = new Sin();
        System.out.println(sin.sin(Math.PI,1e-15));

        Cos cos = new Cos();
        System.out.println(cos.cos(0, 1e-6));

        Sec sec = new Sec();
        System.out.println(sec.sec(0, 0.00001));

        Csc csc = new Csc();
        System.out.println(csc.csc(Math.PI/2, 0.00001));

    }
}
