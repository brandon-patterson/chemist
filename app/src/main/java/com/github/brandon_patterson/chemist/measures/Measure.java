package com.github.brandon_patterson.chemist.measures;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;

public class Measure {
    private static final String UNDERLINED_ZERO = "<u>0</u>";
    private static final char DECIMAL = DecimalFormatSymbols.getInstance().getDecimalSeparator();

    BigDecimal value;
    int significantDigits;
    // TODO: support units

    public Measure(double value, int significantDigits)
    {
        this(new BigDecimal(value), significantDigits);
    }

    private Measure(BigDecimal value, int significantDigits)
    {
        this.value = value;
        this.significantDigits = significantDigits;
    }

    public Measure add(Measure other)
    {
        if (this.value.compareTo(BigDecimal.ZERO) == 0)
        {
            return other;
        }
        else if (other.value.compareTo(BigDecimal.ZERO) == 0)
        {
            return this;
        }
        BigDecimal sum = this.value.add(other.value);
        int lastSignificantDecimalPlace = Math.max(
                this.getLastSignificantDecimalPlace(),
                other.getLastSignificantDecimalPlace());
        int sigFigs = getSigFigs(sum, lastSignificantDecimalPlace);
        return new Measure(sum, sigFigs);
    }

    public Measure subtract(Measure other)
    {
        if (this.value.compareTo(BigDecimal.ZERO) == 0)
        {
            return new Measure(other.value.negate(), other.significantDigits);
        }
        else if (other.value.compareTo(BigDecimal.ZERO) == 0)
        {
            return this;
        }
        BigDecimal difference = this.value.subtract(other.value);
        int lastSignificantDecimalPlace = Math.max(
                this.getLastSignificantDecimalPlace(),
                other.getLastSignificantDecimalPlace());
        int sigFigs = getSigFigs(difference, lastSignificantDecimalPlace);
        return new Measure(difference, sigFigs);
    }

    public Measure multiply(Measure other)
    {
        if (this.value.compareTo(BigDecimal.ZERO) == 0
                || other.value.compareTo(BigDecimal.ZERO) == 0)
        {
            return new Measure(0, 0);
        }
        BigDecimal value = this.value.multiply(other.value);
        int sigFigs = Math.min(this.significantDigits, other.significantDigits);
        return new Measure(value, sigFigs);
    }

    public Measure divide(Measure other)
    {
        if (this.value.compareTo(BigDecimal.ZERO) == 0)
        {
            return new Measure(0, 0);
        }
        else if (other.value.compareTo(BigDecimal.ZERO) == 0)
        {
            throw new IllegalArgumentException("Attempted division by zero");
        }
        MathContext context = new MathContext(20, RoundingMode.HALF_UP);
        BigDecimal value = this.value.divide(other.value, context);
        int sigFigs = Math.min(this.significantDigits, other.significantDigits);
        return new Measure(value, sigFigs);
    }

    @Override
    public boolean equals(Object other)
    {
        if (other == null || other.getClass() != this.getClass())
        {
            return false;
        }
        Measure otherMeasure = (Measure) other;
        return this.toString().equals(otherMeasure.toString());
    }

    @Override
    public int hashCode()
    {
        return this.toString().hashCode();
    }

    @Override
    public String toString()
    {
        if(value.compareTo(BigDecimal.ZERO) == 0)
        {
            return "0";
        }

        String converted = value.abs().round(new MathContext(significantDigits)).toPlainString();

        // if we have an integer result with no significant decimal places
        if (value.abs().compareTo((new BigDecimal(10)).pow(significantDigits - 1)) >= 0)
        {
            converted = highlightLastSignificantZero(converted);
        }
        // if we have an integer result with significant decimal places
        else if (!converted.contains(String.valueOf(DECIMAL)))
        {
            converted = addTrailingZerosAfterDecimalForInteger(converted);
        }
        // else we already have a decimal
        else
        {
            converted = addTrailingZerosToDecimal(converted);
        }

        if (value.compareTo(BigDecimal.ZERO) < 0)
        {
            converted = "-" + converted;
        }

        return converted;
    }

    private String highlightLastSignificantZero(String positiveIntegerString) {
        // if the least significant digit is a zero
        if (positiveIntegerString.charAt(significantDigits - 1) == '0')
        {
            // highlight it
            positiveIntegerString = positiveIntegerString.substring(0, significantDigits - 1)
                    + UNDERLINED_ZERO
                    + positiveIntegerString.substring(significantDigits);
        }
        return positiveIntegerString;
    }

    private String addTrailingZerosAfterDecimalForInteger(String positiveIntegerString) {

        int digitsNeeded = significantDigits - positiveIntegerString.length();
        positiveIntegerString += DECIMAL;
        for(int i = 0; i<digitsNeeded; i++)
        {
            positiveIntegerString += '0';
        }
        return positiveIntegerString;
    }

    private String addTrailingZerosToDecimal(String positiveDecimalString) {
        int sigFigsInString = 0;
        boolean countZeros = false;
        for(int i=0; i<positiveDecimalString.length(); i++)
        {
            if(positiveDecimalString.charAt(i) == '0')
            {
                sigFigsInString += countZeros ? 1 : 0;
            }
            else if (positiveDecimalString.charAt(i) == DECIMAL)
            {
                // do nothing
            }
            else  // char is non-zero digit
            {
                sigFigsInString++;
                countZeros = true;
            }
        }

        for (int i=significantDigits-sigFigsInString; i > 0; i--)
        {
            positiveDecimalString += '0';
        }
        return positiveDecimalString;
    }

    private int getLastSignificantDecimalPlace()
    {
        // zero is special, it'll break the logic further down
        if (value.compareTo(BigDecimal.ZERO) == 0)
        {
            return -significantDigits + 1;
        }

        BigDecimal tmp = value.abs();
        int place = -significantDigits;

        // abs(value) > 1
        if(tmp.compareTo(BigDecimal.ONE) >= 0)
        {
            while(tmp.compareTo(BigDecimal.ONE) > 0)
            {
                place++;
                tmp = tmp.movePointLeft(1);
            }
        }
        // abs(value) < 1
        else
        {
            BigDecimal oneTenth = BigDecimal.ONE.movePointLeft(1);
            while(tmp.compareTo(oneTenth) < 0)
            {
                place--;
                tmp = tmp.movePointRight(1);
            }
        }

        return place;
    }

    private int getSigFigs(BigDecimal value, int lastSignificantDecimalPlace) {
        int sigFigs = 0;
        BigDecimal tmp = value
                .abs()
                .movePointLeft(lastSignificantDecimalPlace)
                .round(new MathContext(0, RoundingMode.FLOOR));
        while (tmp.compareTo(BigDecimal.ONE) >= 0)
        {
            sigFigs++;
            tmp = tmp.movePointLeft(1);
        }
        return sigFigs;
    }
}
