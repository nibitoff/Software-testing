pckage trigonometric;

import static trigonometric.Cos.evalCos;

public class Sec {
    public static double evalSec(double x, double eps) {
        double result;
        double cosValue = evalCos(x, eps);
        if(x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY || cosValue == 0){
            return Double.NaN;
        }
        result = 1 / cosValue;
        return result;
    }
}
