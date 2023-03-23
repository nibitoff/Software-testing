package logarithmic;

public class NaturalLogarithm  {

    public static double evalLn(double x, double eps) {
        if (Double.isNaN(x) || x < (double) 0) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else if (x == 0.0) {
            return Double.NEGATIVE_INFINITY;
        }
        x -= 1;

        // ln(1+a): ряд сходится для |a| < 1
        double res = 0;
        int step = 1;
        double addition = Math.pow(-1, step + 1) * Math.pow(x, step) / step;
        while (Math.abs(addition) > eps / 2) {
            addition = Math.pow(-1, step + 1) * Math.pow(x, step) / step;
            res += addition;
            step++;
        }
        return res;
    }
}
