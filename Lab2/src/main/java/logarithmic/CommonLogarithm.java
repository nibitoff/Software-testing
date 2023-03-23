package logarithmic;

import static logarithmic.NaturalLogarithm.evalLn;

public class CommonLogarithm {
    public static double evalLog(double a, double b, double esp) {
        return evalLn(b, esp) / evalLn(a, esp);
    }
}
