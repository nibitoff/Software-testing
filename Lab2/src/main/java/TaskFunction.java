import logarithmic.CommonLogarithm;
import logarithmic.NaturalLogarithm;

import java.util.Scanner;

public class TaskFunction {
    public static void main (String[] args){
        System.out.println("lab 2");
        Scanner s = new Scanner(System.in);
        float f = s.nextFloat();
        NaturalLogarithm ln = new NaturalLogarithm();
        System.out.println(ln.series(f, 1e-6));

        CommonLogarithm log = new CommonLogarithm();
        System.out.println(log.eval(0.3, 1.3, 1e-6));
    }
}
