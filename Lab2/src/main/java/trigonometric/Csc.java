package trigonometric;

public class Csc {
    public double csc(double x, double eps) {
        Sin sin = new Sin();
        double result;
        double sinValue = sin.sin(x, eps);
        if(x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY || sinValue == 0){
            return Double.NaN;
        }
        result = 1 / sinValue;
        return result;
    }
}
