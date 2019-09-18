package com.github.brandon_patterson.chemist.matter;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class ChemicalEquationTest {

    @Test
    public void testToString()
    {
        Chemical glucose = Chemical.Builder.newInstance()
                .add(Element.C, 6)
                .add(Element.H, 12)
                .add(Element.O, 6)
                .build();

        Chemical oxygen = Chemical.Builder.newInstance()
                .add(Element.O, 2)
                .build();

        Chemical carbonDioxide = Chemical.Builder.newInstance()
                .add(Element.C)
                .add(Element.O, 2)
                .build();

        Chemical water = Chemical.Builder.newInstance().
                add(Element.H, 2).
                add(Element.O).
                build();

        ChemicalEquation respiration = new ChemicalEquation();
        respiration.addReactant(glucose);
        respiration.addReactant(oxygen);
        respiration.addProduct(carbonDioxide);
        respiration.addProduct(water);

        assertThat(respiration.toString()).isEqualTo("C6H12O6 + O2 => CO2 + H2O");
    }
}
