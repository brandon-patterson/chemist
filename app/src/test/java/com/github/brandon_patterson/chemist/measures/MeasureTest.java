package com.github.brandon_patterson.chemist.measures;

import junit.framework.Assert;

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

    @Test
    public void testToString_zeroIsSpecial()
    {
        assertThat(new Measure(0, 0).toString()).isEqualTo("0");
        assertThat(new Measure(0, 1).toString()).isEqualTo("0");
        assertThat(new Measure(0, 2).toString()).isEqualTo("0");
    }

    private void assertSigFigHasExpectedOutput(double value, int sigFigs, String expectedOutput)
    {
        assertThat(new Measure(value, sigFigs).toString()).isEqualTo(expectedOutput);
        assertThat(new Measure(-value, sigFigs).toString()).isEqualTo("-" + expectedOutput);
    }

    @Test
    public void testAdd_sameSignificantDigitAndNoCarry()
    {
        Measure a = new Measure(123.45, 5);
        Measure b = new Measure(43.21, 5);
        assertThat(a.add(b).toString()).isEqualTo("166.66");
        assertThat(b.add(a).toString()).isEqualTo("166.66");
    }

    @Test
    public void testAdd_sameSignificantDigitAndCarry()
    {
        Measure a = new Measure(123.45, 5);
        Measure b = new Measure(987.65, 5);
        assertThat(a.add(b).toString()).isEqualTo("1111.10");
        assertThat(b.add(a).toString()).isEqualTo("1111.10");
    }

    @Test
    public void testAdd_diffSignificantDigitAndNoCarry()
    {
        Measure a = new Measure(123.45, 5);
        Measure b = new Measure(543, 3);
        assertThat(a.add(b).toString()).isEqualTo("666");
        assertThat(b.add(a).toString()).isEqualTo("666");
    }

    @Test
    public void testAdd_diffSignificantDigitAndCarry()
    {
        Measure a = new Measure(123.45, 5);
        Measure b = new Measure(987, 3);
        assertThat(a.add(b).toString()).isEqualTo("111<u>0</u>");
        assertThat(b.add(a).toString()).isEqualTo("111<u>0</u>");
    }

    @Test
    public void testAdd_zeroIsSpecial()
    {
        Measure notZero = new Measure(123.45, 5);
        Measure zero = new Measure(0,0);
        assertThat(notZero.add(zero).toString()).isEqualTo(notZero.toString());
        assertThat(zero.add(notZero).toString()).isEqualTo(notZero.toString());
    }

    @Test
    public void testSubtract_sameSignificantDigitAndNoCarry()
    {
        Measure a = new Measure(123.45, 5);
        Measure b = new Measure(23.45, 5);
        assertThat(a.subtract(b).toString()).isEqualTo("100.00");
        assertThat(b.subtract(a).toString()).isEqualTo("-100.00");
    }

    @Test
    public void testSubtract_sameSignificantDigitAndCarry()
    {
        Measure a = new Measure(123.45, 5);
        Measure b = new Measure(120, 5);
        assertThat(a.subtract(b).toString()).isEqualTo("3.45");
        assertThat(b.subtract(a).toString()).isEqualTo("-3.45");
    }

    @Test
    public void testSubtract_diffSignificantDigitAndNoCarry()
    {
        Measure a = new Measure(123.45,5);
        Measure b = new Measure(543.21, 3);
        assertThat(a.subtract(b).toString()).isEqualTo("-42<u>0</u>");
        assertThat(b.subtract(a).toString()).isEqualTo("42<u>0</u>");
    }

    @Test
    public void testSubtract_diffSignificantDigitAndCarry()
    {
        Measure a = new Measure(123.45, 5);
        Measure b = new Measure(120, 3);
        assertThat(a.subtract(b).toString()).isEqualTo("3");
        assertThat(b.subtract(a).toString()).isEqualTo("-3");
    }

    @Test
    public void testSubtract_zeroIsSpecial()
    {
        Measure notZero = new Measure(123.45, 5);
        Measure zero = new Measure(0,0);
        assertThat(notZero.subtract(zero).toString()).isEqualTo(notZero.toString());
        assertThat(zero.subtract(notZero).toString()).isEqualTo("-" + notZero.toString());
    }

    @Test
    public void testMultiply_sameSignificantDigit()
    {
        Measure a = new Measure(123.45, 5);
        Measure b = new Measure(543.21, 5);
        assertThat(a.multiply(b).toString()).isEqualTo("67059");
        assertThat(b.multiply(a).toString()).isEqualTo("67059");
    }

    @Test
    public void testMultiply_diffSignificantDigit()
    {
        Measure a = new Measure(123.45, 5);
        Measure b = new Measure(543.21, 3);
        assertThat(a.multiply(b).toString()).isEqualTo("67100");
        assertThat(b.multiply(a).toString()).isEqualTo("67100");
    }

    @Test
    public void testMultiply_zeroIsSpecial()
    {
        Measure notZero = new Measure(123.45, 5);
        Measure zero = new Measure(0,0);
        assertThat(notZero.multiply(zero).toString()).isEqualTo(zero.toString());
        assertThat(zero.multiply(notZero).toString()).isEqualTo(zero.toString());
    }

    @Test
    public void testDivide_sameSignificantDigit()
    {
        Measure a = new Measure(3, 2);
        Measure b = new Measure(1, 2);
        assertThat(a.divide(b).toString()).isEqualTo("3.0");
        assertThat(b.divide(a).toString()).isEqualTo("0.33");
    }

    @Test
    public void testDivide_diffSignificantDigit()
    {
        Measure a = new Measure(3, 2);
        Measure b = new Measure(1, 1);
        assertThat(a.divide(b).toString()).isEqualTo("3");
        assertThat(b.divide(a).toString()).isEqualTo("0.3");
    }

    @Test
    public void testDivide_zeroIsSpecial() throws Exception
    {
        Measure notZero = new Measure(123.45, 5);
        Measure zero = new Measure(0,0);
        assertThat(zero.divide(notZero).toString()).isEqualTo(zero.toString());
        try
        {
            notZero.divide(zero);
            Assert.fail("Expected IllegalArgumentException for division by zero");
        }
        catch (IllegalArgumentException ex)
        {
            // pass
        }
        catch (Exception ex)
        {
            Assert.fail("Expected IllegalArgumentException for division by zero");
        }
    }

    @Test
    public void testEquals()
    {
        assertThat(new Measure(1, 1)).isEqualTo(new Measure(1, 1));
        assertThat(new Measure(1, 1)).isNotEqualTo(new Measure(2, 1));
        assertThat(new Measure(1, 1)).isNotEqualTo(new Measure(1, 2));
    }

    @Test
    public void testHashCode()
    {
        assertThat(new Measure(1, 1).hashCode())
                .isEqualTo(new Measure(1, 1).hashCode());
        assertThat(new Measure(1, 1).hashCode())
                .isNotEqualTo(new Measure(2, 1).hashCode());
        assertThat(new Measure(1, 1).hashCode())
                .isNotEqualTo(new Measure(1, 2).hashCode());
    }
}
