package trigonometric;

import static trigonometric.Sin.evalSin;

public class Csc {
    public static double evalCsc(double x, double eps) {
        double result;
        double sinValue = evalSin(x, eps);
        if(x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY || sinValue == 0){
            return Double.NaN;
        }
        result = 1 / sinValue;
        return result;
    }
}
