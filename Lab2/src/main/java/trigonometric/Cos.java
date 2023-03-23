package trigonometric;

import static trigonometric.Sin.evalSin;

public class Cos {
    public static double evalCos(double x, double eps) {
        double result = 0;
        if(x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY){
            return Double.NaN;
        }
        if (x >= 0) {
            while (x > Math.PI) {
                x -= Math.PI * 2;
            }
        } else if (x < 0) {
            while (x < -Math.PI) {
                x += Math.PI * 2;
            }
        }
        //correcting sign
        if (x > Math.PI / 2 || x < -Math.PI / 2) {
            result = -1 * Math.sqrt(1 - evalSin(x, eps) * evalSin(x, eps));
        } else {
            result = Math.sqrt(1 - evalSin(x, eps) * evalSin(x, eps));
        }
        if (Math.abs(result) > 1) return Double.NaN;
        if (Math.abs(result) <= eps) return 0;
        return result;
    }
}
