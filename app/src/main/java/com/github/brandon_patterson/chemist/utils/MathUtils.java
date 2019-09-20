package com.github.brandon_patterson.chemist.utils;

public class MathUtils {

    private MathUtils() { /* cannot be instantiated */ }

    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static int gcd(Iterable<Integer> ints)
    {
        int result = 0;
        for (Integer i : ints)
        {
            if(result == 0)
            {
                result = i;
            }
            else
            {
                result = gcd(i, result);
            }
        }
        return result;
    }
}
