package com.github.brandon_patterson.chemist.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class StringUtilsTest
{
    @Test
    public void testJoin()
    {
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        assertThat(StringUtils.join(", ", ints)).isEqualTo("1, 2, 3");
    }
}
