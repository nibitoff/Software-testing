package main.java.task1;

public class ArcTanFunction {
    public static Double getArcTan(double x) {
        double precision = 1E-10;;
        double result = x, a = 1;
        int s = 1;
        int sign = 1;

        if (Math.abs(x) > 1) return Double.NaN;
        if (x == 1.0) return Math.PI / 4;
        if (x == -1.0) return -Math.PI / 4;

        for (int i = 3; i < 1000000000; i += 2) {
            sign = sign % 2;

            if (sign == 0) {
                result += Math.pow(x, i) / i;

            } else {
                result -= Math.pow(x, i) / i;
            }

            s++;
            a = Math.abs(Math.pow(x, i + 2) / (i + 2));
            if (precision > a) {
                break;
            }
            sign++;
        }
        return result;
    }
    }
