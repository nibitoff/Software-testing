package trigonometric;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.IOException;
import java.io.Writer;

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

    public double writeCscToCSV(double x, double eps, Writer out) {
        double res = csc(x, eps);
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Wrong filename");
        }
        return res;
    }
}
