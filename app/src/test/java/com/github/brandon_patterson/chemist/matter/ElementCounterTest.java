package com.github.brandon_patterson.chemist.matter;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

public class ElementCounterTest {

    @Test
    public void testGetCounts()
    {
        // (NH4)2O
        Chemical ammoniumOxide = Chemical.Builder.newInstance()
                .add(Chemical.Builder.newInstance()
                        .add(Element.N)
                        .add(Element.H, 4)
                        .build(), 2)
                .add(Element.O)
                .build();

        Map<Element, Integer> expected = new HashMap<>();
        expected.put(Element.N, 2);
        expected.put(Element.H, 8);
        expected.put(Element.O, 1);

        assertThat(ElementCounter.getCounts(ammoniumOxide))
                .containsExactlyEntriesIn(expected);
    }
}
