package com.github.brandon_patterson.chemist.utils;

public class StringUtils {

    public static <T> String join(String delimiter, Iterable<T> collection)
    {
        StringBuilder sb = new StringBuilder();

        for(T element : collection)
        {
            if(sb.length() > 0)
            {
                sb.append(delimiter);
            }
            sb.append(element);
        }

        return sb.toString();
    }

    private StringUtils() { /* cannot be instantiated */ }
}
