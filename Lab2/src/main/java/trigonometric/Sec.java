package trigonometric;

public class Sec {
    public double sec(double x, double eps) {
        Cos cos = new Cos();
        double result;
        double cosValue = cos.cos(x, eps);
        if(x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY || cosValue == 0){
            return Double.NaN;
        }
        result = 1 / cosValue;
        return result;
    }

}
