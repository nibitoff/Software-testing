import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import taskFunction.TaskFunction;
import trigonometric.*;
import logarithmic.*;
import utils.CsvLog;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TaskFunctionTest {
    static Sec secMock;
    static Cos cosMock;
    static Sin sinMock;
    static Csc cscMock;
    static NaturalLogarithm lnMock;
    static CommonLogarithm logMock;

    static Reader secIn;
    static Reader cosIn;
    static Reader sinIn;
    static Reader lnIn;
    static Reader cscIn;
    static Reader log2In;
    static Reader log5In;
    static Reader log3In;
    static double eps = 0.000000000001;
    static double feps = 0.0001;

    private final CsvLog csvLog = new CsvLog();


    @BeforeAll
    public static void initTest() throws IOException {
        cosMock = Mockito.mock(Cos.class);
        cscMock = Mockito.mock(Csc.class);
        secMock = Mockito.mock(Sec.class);
        sinMock = Mockito.mock(Sin.class);
        logMock = Mockito.mock(CommonLogarithm.class);
        lnMock = Mockito.mock(NaturalLogarithm.class);
        try {
            cscIn = new FileReader("src/main/resources/Inputs/CscIn.csv");
            cosIn = new FileReader("src/main/resources/Inputs/CosIn.csv");
            secIn = new FileReader("src/main/resources/Inputs/SecIn.csv");
            sinIn = new FileReader("src/main/resources/Inputs/SinIn.csv");
            lnIn = new FileReader("src/main/resources/Inputs/LnIn.csv");
            log2In = new FileReader("src/main/resources/Inputs/Log2In.csv");
            log5In = new FileReader("src/main/resources/Inputs/Log5In.csv");
            log3In = new FileReader("src/main/resources/Inputs/Log3In.csv");

            Iterable<CSVRecord> records;
            records = CSVFormat.DEFAULT.parse(cosIn);
            for (CSVRecord record : records) {
                Mockito.when(cosMock.cos(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cscIn);
            for (CSVRecord record : records) {
                Mockito.when(cscMock.csc(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
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
            records = CSVFormat.DEFAULT.parse(log3In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(3, Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log3In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.log(5, Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
            }
        } catch (IOException ex) {
            System.err.println("IO ERROR!");
        }

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/FunctionIn.csv")
    void testFunctionWithMocks(double value, double expected) {
        TaskFunction function = new TaskFunction(logMock, lnMock, secMock, cscMock, sinMock);
        Assertions.assertEquals(expected, function.evalTask(value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/FunctionOut.csv");
        csvLog.logger(expected, function.evalTask(value, eps), feps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/FunctionIn.csv")
    void testFunctionOnCsc(double value, double expected) {
        TaskFunction function = new TaskFunction(logMock, lnMock, secMock, new Csc(sinMock), sinMock);
        Assertions.assertEquals(expected, function.evalTask(value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/CscOut.csv");
        csvLog.logger(expected, function.evalTask(value, eps), feps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/FunctionIn.csv")
    void testFunctionOnSec(double value, double expected) {
        TaskFunction function = new TaskFunction(logMock, lnMock, new Sec(cosMock), cscMock, sinMock);
        Assertions.assertEquals(expected, function.evalTask(value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/SecOut.csv");
        csvLog.logger(expected, function.evalTask(value, eps), feps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/FunctionIn.csv")
    void testFunctionOnSin(double value, double expected) {
        TaskFunction function = new TaskFunction(logMock, lnMock, new Sec(new Cos(new Sin())), cscMock, sinMock);
        Assertions.assertEquals(expected, function.evalTask(value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/SinOut.csv");
        csvLog.logger(expected, function.evalTask(value, eps), feps);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/FunctionIn.csv")
    void testFunctionOnCommonLog(double value, double expected) {
        TaskFunction function = new TaskFunction(new CommonLogarithm(lnMock), lnMock, secMock, cscMock, sinMock);
        Assertions.assertEquals(expected, function.evalTask(value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/LogOut.csv");
        csvLog.logger(expected, function.evalTask(value, eps), feps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/FunctionIn.csv")
    void testFunctionOnNaturalLog(double value, double expected) {
        TaskFunction function = new TaskFunction(new CommonLogarithm(), new NaturalLogarithm(), secMock, cscMock, sinMock);
        Assertions.assertEquals(expected, function.evalTask(value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/LnOut.csv");
        csvLog.logger(expected, function.evalTask(value, eps), feps);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/CscIn.csv")
    void testCsc(double value, double expected) {
        Csc function = new Csc(sinMock);
        Assertions.assertEquals(expected, function.csc(value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/CscOut.csv");
        csvLog.logger(expected, function.csc(value, eps), feps);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/SecIn.csv")
    void testSec(double value, double expected) {
        Sec function = new Sec(cosMock);
        Assertions.assertEquals(expected, function.sec(value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/SecOut.csv");
        csvLog.logger(expected, function.sec(value, eps), feps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/SinIn.csv")
    void testSin(double value, double expected) {
        Sin function = new Sin();
        Assertions.assertEquals(expected, function.sin(value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/SinOut.csv");
        csvLog.logger(expected, function.sin(value, eps), feps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/Log2In.csv")
    void testLog2(double value, double expected) {
        CommonLogarithm log = new CommonLogarithm(new NaturalLogarithm());
        Assertions.assertEquals(expected, log.log(2,value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/Log2Out.csv");
        csvLog.logger(expected, log.log(2, value, eps), feps);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/Log3In.csv")
    void testLog3(double value, double expected) {
        CommonLogarithm log = new CommonLogarithm(new NaturalLogarithm());
        Assertions.assertEquals(expected, log.log(3,value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/Log3Out.csv");
        csvLog.logger(expected, log.log(3, value, eps), feps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/Log5In.csv")
    void testLog5(double value, double expected) {
        CommonLogarithm log = new CommonLogarithm(new NaturalLogarithm());
        Assertions.assertEquals(expected, log.log(5,value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/Log5Out.csv");
        csvLog.logger(expected, log.log(5, value, eps), feps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Inputs/LnIn.csv")
    void testLn(double value, double expected) {
        NaturalLogarithm log = new NaturalLogarithm();
        Assertions.assertEquals(expected, log.ln(value, eps), feps);
        csvLog.setFilePath("src/main/resources/Outputs/LnOut.csv");
        csvLog.logger(expected, log.ln( value, eps), feps);
    }
}