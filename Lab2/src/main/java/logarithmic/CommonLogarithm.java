package logarithmic;

public class CommonLogarithm {
    private final NaturalLogarithm ln;

    public CommonLogarithm() {
        this.ln = new NaturalLogarithm();
    }

    public double eval(double a, double b, double esp) {
        return ln.series(b, esp) / ln.series(a, esp);
    }
}
