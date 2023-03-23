package trigonometric;

public class Sin {
    public static double evalSin(double x, double eps){
        if(x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY){
            return Double.NaN;
        }
        double fact = 1, result_l = 1, result = 0;
        int sign = 1, i = 1;

        if (x >= 0) {
            while (x > Math.PI * 2) {
                x -= Math.PI * 2;
            }
        } else if (x < 0) {
            while (x < Math.PI * 2) {
                x += Math.PI * 2;
            }
        }

        while (Math.abs(result_l - result) > eps) {
            fact = fact / i;
            result_l = result;
            result += sign * Math.pow(x, i) * fact;
            sign = -sign;
            fact = fact / (i + 1);
            i += 2;
        }
        if (Math.abs(result) > 1) return Double.NaN;
        if (Math.abs(result) < eps) return 0;
        return result;
    }
}
