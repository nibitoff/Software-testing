package trigonometric;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.IOException;
import java.io.Writer;

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

    public double writeSecToCSV(double x, double eps, Writer out) {
        double res = sec(x, eps);
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Wrong filename");
        }
        return res;
    }

}
