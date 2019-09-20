package com.github.brandon_patterson.chemist.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class MathUtilsTest {

    @Test
    public void testGcd()
    {
        List<Integer> ints = new ArrayList<>();
        ints.add(12);
        ints.add(42);
        ints.add(60);
        assertThat(MathUtils.gcd(ints)).isEqualTo(6);

        ints.add(21);
        assertThat(MathUtils.gcd(ints)).isEqualTo(3);
    }
}
