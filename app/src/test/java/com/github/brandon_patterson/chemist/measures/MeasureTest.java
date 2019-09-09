package com.github.brandon_patterson.chemist.measures;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class MeasureTest {

    @Test
    public void testToString_withMatchingNumberOfDigits()
    {
        assertSigFigHasExpectedOutput(42, 2, "42");
        assertSigFigHasExpectedOutput(100, 3, "10<u>0</u>");
        assertSigFigHasExpectedOutput(123450, 5, ("123450"));
        assertSigFigHasExpectedOutput(1.23, 3, "1.23");
        assertSigFigHasExpectedOutput(0.0456, 3, "0.0456");
    }

    @Test
    public void testToString_withTooManyDigits()
    {
        assertSigFigHasExpectedOutput(42, 1, "40");
        assertSigFigHasExpectedOutput(123456789, 3, "123000000");
        assertSigFigHasExpectedOutput(123450, 4, ("123500"));
        assertSigFigHasExpectedOutput(100.001, 5, "100.00");
        assertSigFigHasExpectedOutput(1.23, 2, "1.2");
        assertSigFigHasExpectedOutput(0.0456, 2, "0.046");
    }

    @Test
    public void testToString_withSignificantTrailingZeros()
    {
        assertSigFigHasExpectedOutput(42, 3, "42.0");
        assertSigFigHasExpectedOutput(123450, 6, ("12345<u>0</u>"));
        assertSigFigHasExpectedOutput(101, 2, "1<u>0</u>0");
        assertSigFigHasExpectedOutput(10001, 3, "10<u>0</u>00");
        assertSigFigHasExpectedOutput(1.23, 6, "1.23000");
        assertSigFigHasExpectedOutput(.5, 5, "0.50000");
        assertSigFigHasExpectedOutput(0.0456, 4, "0.04560");

        double value = 0.1;
        String expectedString = "0.1";
        for(int sigFigs=2; sigFigs<16; sigFigs++)
        {
            expectedString += "0";
            assertSigFigHasExpectedOutput(value, sigFigs, expectedString);
        }
    }

    private void assertSigFigHasExpectedOutput(double value, int sigFigs, String expectedOutput)
    {
        assertThat(new Measure(value, sigFigs).toString()).isEqualTo(expectedOutput);
        assertThat(new Measure(-value, sigFigs).toString()).isEqualTo("-" + expectedOutput);
    }

    @Test
    public void testAdd_sameSignificantDigitAndNoCarry()
    {
        Measure left = new Measure(123.45, 5);
        Measure right = new Measure(43.21, 5);
        assertThat(left.add(right).toString()).isEqualTo("166.66");
        assertThat(right.add(left).toString()).isEqualTo("166.66");
    }

    @Test
    public void testAdd_sameSignificantDigitAndCarry()
    {
        Measure left = new Measure(123.45, 5);
        Measure right = new Measure(987.65, 5);
        assertThat(left.add(right).toString()).isEqualTo("1111.10");
        assertThat(right.add(left).toString()).isEqualTo("1111.10");
    }

    @Test
    public void testAdd_diffSignificantDigitAndNoCarry()
    {
        Measure left = new Measure(123.45, 5);
        Measure right = new Measure(543, 3);
        assertThat(left.add(right).toString()).isEqualTo("666");
        assertThat(right.add(left).toString()).isEqualTo("666");
    }

    @Test
    public void testAdd_diffSignificantDigitAndCarry()
    {
        Measure left = new Measure(123.45, 5);
        Measure right = new Measure(987, 3);
        assertThat(left.add(right).toString()).isEqualTo("111<u>0</u>");
        assertThat(right.add(left).toString()).isEqualTo("111<u>0</u>");
    }

    @Test
    public void testSubtract_sameSignificantDigitAndNoCarry()
    {
        Measure left = new Measure(123.45, 5);
        Measure right = new Measure(23.45, 5);
        assertThat(left.subtract(right).toString()).isEqualTo("100.00");
        assertThat(right.subtract(left).toString()).isEqualTo("-100.00");
    }

    @Test
    public void testSubtract_sameSignificantDigitAndCarry()
    {
        Measure left = new Measure(123.45, 5);
        Measure right = new Measure(120, 5);
        assertThat(left.subtract(right).toString()).isEqualTo("3.45");
        assertThat(right.subtract(left).toString()).isEqualTo("-3.45");
    }

    @Test
    public void testSubtract_diffSignificantDigitAndNoCarry()
    {
        Measure left = new Measure(123.45,5);
        Measure right = new Measure(543.21, 3);
        assertThat(left.subtract(right).toString()).isEqualTo("-42<u>0</u>");
        assertThat(right.subtract(left).toString()).isEqualTo("42<u>0</u>");
    }

    @Test
    public void testSubtract_diffSignificantDigitAndCarry()
    {
        Measure left = new Measure(123.45, 5);
        Measure right = new Measure(120, 3);
        assertThat(left.subtract(right).toString()).isEqualTo("3");
        assertThat(right.subtract(left).toString()).isEqualTo("-3");
    }

    @Test
    public void testMultiply_sameSignificantDigit()
    {
        Measure left = new Measure(123.45, 5);
        Measure right = new Measure(543.21, 5);
        assertThat(left.multiply(right).toString()).isEqualTo("67059");
        assertThat(right.multiply(left).toString()).isEqualTo("67059");
    }

    @Test
    public void testMultiply_diffSignificantDigit()
    {
        Measure left = new Measure(123.45, 5);
        Measure right = new Measure(543.21, 3);
        assertThat(left.multiply(right).toString()).isEqualTo("67100");
        assertThat(right.multiply(left).toString()).isEqualTo("67100");
    }

    @Test
    public void testDivide_sameSignificantDigit()
    {
        Measure left = new Measure(3, 2);
        Measure right = new Measure(1, 2);
        assertThat(left.divide(right).toString()).isEqualTo("3.0");
        assertThat(right.divide(left).toString()).isEqualTo("0.33");
    }

    @Test
    public void testDivide_diffSignificantDigit()
    {
        Measure left = new Measure(3, 2);
        Measure right = new Measure(1, 1);
        assertThat(left.divide(right).toString()).isEqualTo("3");
        assertThat(right.divide(left).toString()).isEqualTo("0.3");
    }
}
