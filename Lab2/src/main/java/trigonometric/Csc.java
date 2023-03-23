package trigonometric;

public class Csc {
    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public Csc() {
        this.sin = new Sin();
    }

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
