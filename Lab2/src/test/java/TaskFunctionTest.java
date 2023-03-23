import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import trigonometric.*;
import logarithmic.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TaskFunctionTest {
    @BeforeAll
    public static void initTest() throws IOException {
        Cos cosMock = Mockito.mock(Cos.class);
        Csc cscMock = Mockito.mock(Csc.class);
        Sec secMock = Mockito.mock(Sec.class);
        Sin sinMock = Mockito.mock(Sin.class);
        CommonLogarithm logMock = Mockito.mock(CommonLogarithm.class);
        NaturalLogarithm lnMock = Mockito.mock(NaturalLogarithm.class);

        double eps = 0.01;
        Reader secIn;
        Reader cosIn;
        Reader sinIn;
        Reader cscIn;
        Reader lnIn;
        Reader log2In;
        Reader log5In;
        Reader log3In;

        //        cosMock = Mockito.mock(Cos.class);
//        sinMock = Mockito.mock(Sin.class);
//        lnMock = Mockito.mock(NaturalLogarithm.class);
//        logMock = Mockito.mock(CommonLogarithm.class);
//        cscMock = Mockito.mock(Csc.class);

        try{
            cscIn = new FileReader("src/main/java/resources/Inputs/CscOut.csv");
            cosIn = new FileReader("src/main/java/resources/Inputs/CosOut.csv");
            secIn = new FileReader("src/main/java/resources/Inputs/SecOut.csv");
            sinIn = new FileReader("src/main/java/resources/Inputs/SinOut.csv");
            lnIn = new FileReader("src/main/java/resources/Inputs/LnOut.csv");
            log2In = new FileReader("src/main/java/resources/Inputs/Log2Out.csv");
            log5In = new FileReader("src/main/java/resources/Inputs/Log5Out.csv");
            log3In = new FileReader("src/main/java/resources/Inputs/Log3Out.csv");

            Iterable<CSVRecord> records;
            records = CSVFormat.DEFAULT.parse(cosIn);
            for (CSVRecord record : records) {
                Mockito.when(cosMock.cos(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cscIn);
            for (CSVRecord record : records) {
                Mockito.when(secMock.sec(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(secIn);
            for (CSVRecord record : records) {
                Mockito.when(secMock.sec(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(sinIn);
            for (CSVRecord record : records) {
                Mockito.when(sinMock.sin(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(lnIn);
            for (CSVRecord record : records) {
                Mockito.when(lnMock.ln(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log2In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(2, Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log5In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(5, Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log5In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(3, Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
            }
        } catch (IOException ex) {
            System.err.println("IO ERROR!");
        }

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CsvFiles/Inputs/SystemIn.csv")
    void testWithSec(double value, double expected) {
        Function function = new Function(new Sec(cosMock), lnMock, logMock);
        Assertions.assertEquals(expected, function.SystemSolve(value, functionEps), eps);
    }



    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void simpleTest(int value) {
        System.out.println(value);
    }
}
