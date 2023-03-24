package csvWorker;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public class CSVWorker {
    public double writeToCSV(double x, double res, double eps, Writer out) {
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Wrong filename");
        }
        return res;
    }

    public double writeToCSV_2args(double x, double a, double res, Writer out) {
        try (CSVPrinter printer = CSVFormat.DEFAULT.print(out)) {
            printer.printRecord(a, x, res);
        } catch (IOException e) {
            System.out.println("Wrong filename");
        }
        return res;
    }
}
