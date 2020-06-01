package core.basesyntax;

import org.junit.Test;
import org.junit.Assert;

public class CalculatorTest {
    private static final double DELTA = 1e-15;

    @Test
    public void checkSum() {
        Assert.assertEquals(2, Calculator.calculate(1, 1, '+'), DELTA);
        Assert.assertEquals(4, Calculator.calculate(2, 2, '+'), DELTA);
        Assert.assertEquals(80_000_000_000_000d, Calculator.calculate(40_000_000_000_000d, 40_000_000_000_000d, '+'), DELTA);
    }

    @Test
    public void checkDifference() {
        Assert.assertEquals(2, Calculator.calculate(3, 1, '-'), DELTA);
        Assert.assertEquals(4, Calculator.calculate(6, 2, '-'), DELTA);
        Assert.assertEquals(80_000_000_000_000d, Calculator.calculate(120_000_000_000_000d, 40_000_000_000_000d, '-'), DELTA);
    }

    @Test
    public void checkMultiply() {
        Assert.assertEquals(1, Calculator.calculate(1, 1, '*'), DELTA);
        Assert.assertEquals(4, Calculator.calculate(2, 2, '*'), DELTA);
        Assert.assertEquals(40_000_000_000_000d, Calculator.calculate(2_000_000d, 20_000_000d, '*'), DELTA);
    }

    @Test
    public void checkDivide() {
        Assert.assertEquals(2, Calculator.calculate(2, 1, '/'), DELTA);
        Assert.assertEquals(4, Calculator.calculate(2, 0.5, '/'), DELTA);
        Assert.assertEquals(20_000_000_000_000d, Calculator.calculate(40_000_000_000_000d, 2, '/'), DELTA);
    }

    @Test
    public void checkRaise() {
        Assert.assertEquals(2, Calculator.calculate(4, 0.5, '^'), DELTA);
        Assert.assertEquals(4, Calculator.calculate(2, 2, '^'), DELTA);
        Assert.assertEquals(8_000_000_000_000d, Calculator.calculate(20000, 3, '^'), DELTA);
    }

    @Test
    public void divideByZero() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, Calculator.calculate(1, 0, '/'), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIncorrectOperators() {
        Calculator.calculate(2, 2, 'q');
        Calculator.calculate(2, 2, '2');
        Calculator.calculate(2, 2, '<');
        Calculator.calculate(2, 2, '<');
        Calculator.calculate(2, 2, null);
    }
}
