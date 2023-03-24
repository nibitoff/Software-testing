package taskFunction;

import com.opencsv.CSVWriter;
import logarithmic.CommonLogarithm;
import logarithmic.NaturalLogarithm;
import trigonometric.Csc;
import trigonometric.Sec;
import trigonometric.Sin;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TaskFunction {
    CommonLogarithm log;
    NaturalLogarithm ln;
    Sec sec;
    Csc csc;
    Sin sin;

    public TaskFunction() {
        log = new CommonLogarithm();
        ln = new NaturalLogarithm();
        sec = new Sec();
        csc = new Csc();
        sin = new Sin();
    }

    public TaskFunction(CommonLogarithm log, NaturalLogarithm ln, Sec sec, Csc csc, Sin sin) {
        this.log = log;
        this.ln = ln;
        this.sec = sec;
        this.csc = csc;
        this.sin = sin;
    }

    public void getPoints(double leftX, double rightX, double step) throws IOException {
        Writer out = new FileWriter("src/main/resources/Outputs/FunctionOut.csv");
        CSVWriter writer = new CSVWriter(out, ',', CSVWriter.NO_QUOTE_CHARACTER);
        while (leftX < rightX) {
            leftX += step;
            double res = evalTask(leftX, step);
            if(Math.abs(res) < 100) {
                String[] data1 = {String.valueOf(leftX), String.valueOf(res)};
                writer.writeNext(data1);
            }
        }
    }

    // ((sec(x)^2 + csc(x))^6)/sin(x) x <= 0
    // (( ((log base 3 x + log base 5 x) / (ln x / log base 2 x)) - log  base 3 x) * log  base 2 x)^2 > 0
    public double evalTask(double x, double eps) {
        double res;
        if (x < 0 || x < eps) {
            res = Math.pow((Math.pow(sec.sec(x, eps), 2) + csc.csc(x, eps)), 6) / sin.sin(x, eps);
        } else {
            System.out.println(log.log(2, x, eps));
            System.out.println(log.log(3, x, eps));
            System.out.println(log.log(5, x, eps));
            System.out.println(ln.ln(x, eps));
            res = Math.pow(
                    ((log.log(3, x, eps) + log.log(5, x, eps)) * log.log(2, x, eps) / ln.ln(x, eps) - log.log(3, x, eps)) * log.log(2, x, eps)
                    , 2);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("lab 2");

        TaskFunction f = new TaskFunction();

        double res = f.evalTask(-0.523599, 0.0001);
        System.out.println(res);

        Sin sin = new Sin();
//        sin.getPoints(-3, 3, 0.01);

        f.getPoints(-10, 10, 0.001);
    }
}
