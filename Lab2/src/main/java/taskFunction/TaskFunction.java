import static logarithmic.CommonLogarithm.evalLog;
import static trigonometric.Cos.evalCos;
import static trigonometric.Csc.evalCsc;
import static trigonometric.Sec.evalSec;
import static trigonometric.Sin.evalSin;

public class TaskFunction {
    public static void main (String[] args){
        System.out.println("lab 2");

        System.out.println(evalLog(0.3, 1.3, 1e-6));

        System.out.println(evalSin(Math.PI,1e-15));

        System.out.println(evalCos(0, 1e-6));

        System.out.println(evalSec(0, 0.00001));

        System.out.println(evalCsc(Math.PI/2, 0.00001));

    }
}
