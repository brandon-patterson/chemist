package com.github.brandon_patterson.chemist.matter.physicalConstants;

import com.github.brandon_patterson.chemist.matter.Chemical;
import com.github.brandon_patterson.chemist.matter.Element;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class MolarMassTest {

    static double TOLERANCE = 1e-10;

    @Test
    public void testGetMass_element() throws Exception
    {
        assertThat(MolarMass.getMass(Element.CL))
                .isWithin(TOLERANCE)
                .of(35.45);
    }

    @Test
    public void testGetMass_simpleMolecule() throws Exception
    {
        Chemical glucose = Chemical.Builder.newInstance()
                .add(Element.C, 6)
                .add(Element.H, 12)
                .add(Element.O, 6)
                .build();

        assertThat(MolarMass.getMass(glucose))
                .isWithin(TOLERANCE)
                .of(180.156);
    }

    @Test
    public void testGetMass_complexMolecule() throws Exception
    {
        // [C(NH2)3]2SO4
        // (May not be a correct formula, but the mass calculation is still valid)
        Chemical guanidineSulfate = Chemical.Builder.newInstance()
                .add(Chemical.Builder.newInstance()
                        .add(Element.C)
                        .add(Chemical.Builder.newInstance()
                                .add(Element.N)
                                .add(Element.H, 2)
                                .build(), 3)
                        .build(),2)
                .add(Chemical.Builder.newInstance()
                        .add(Element.S)
                        .add(Element.O, 4)
                        .build())
                .build();

        assertThat(MolarMass.getMass(guanidineSulfate))
                .isWithin(TOLERANCE)
                .of(216.216);
    }
}
