package test.java.task1;

import main.java.task1.ArcTanFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ArcTanFunctionTest {
    double eps = 1E-10;

    @ParameterizedTest
    @ValueSource(doubles = {-1.0001, -11.0})
    public void negativeCheck(double value) {
        Assertions.assertEquals(Double.NaN, ArcTanFunction.getArcTan(value), eps, "Out of bounds test failed!");
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.895, -0.995})
    public void negativeCloseCheck(double value) {
        Assertions.assertEquals(Math.atan(value), ArcTanFunction.getArcTan(value), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.00000000000000001, -0.005, 3E-25})
    public void negativeZeroCloseCheck(double value) {
        Assertions.assertEquals(Math.atan(value), ArcTanFunction.getArcTan(value), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0001, 0.005})
    public void positiveZeroCloseCheck(double value) {
        Assertions.assertEquals(Math.atan(value), ArcTanFunction.getArcTan(value), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.895, 0.995})
    public void positiveCloseCheck(double value) {
        Assertions.assertEquals(Math.atan(value), ArcTanFunction.getArcTan(value), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.0001, 11.0})
    public void positiveCheck(double value) {
        Assertions.assertEquals(Double.NaN, ArcTanFunction.getArcTan(value), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.000001, -0.000001})
    public void zeroCheck(double value) {
        Assertions.assertEquals(Math.atan(value), ArcTanFunction.getArcTan(value), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.0, -1.0})
    public void CloseCheck(double value) {
        Assertions.assertEquals(Math.atan(value), ArcTanFunction.getArcTan(value), eps);
    }
}