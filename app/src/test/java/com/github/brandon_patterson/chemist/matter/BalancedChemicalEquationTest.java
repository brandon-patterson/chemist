package com.github.brandon_patterson.chemist.matter;

import org.junit.Assert;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class BalancedChemicalEquationTest {

    private Chemical oxygen = Chemical.Builder.newInstance()
            .add(Element.O, 2)
            .build();

    private Chemical carbonDioxide = Chemical.Builder.newInstance()
            .add(Element.C)
            .add(Element.O, 2)
            .build();

    private Chemical water = Chemical.Builder.newInstance().
            add(Element.H, 2).
            add(Element.O).
            build();

    @Test
    public void testBalance_identity() throws Exception
    {
        ChemicalEquation identity = ChemicalEquation.Builder.newInstance()
                .addReactant(oxygen)
                .addProduct(oxygen)
                .build();
        assertThat(BalancedChemicalEquation.balance(identity).toString()).isEqualTo("O2 => O2");
    }

    @Test
    public void testBalance_composition() throws Exception
    {
        Chemical atomicChlorine = Chemical.Builder.newInstance().add(Element.CL).build();
        Chemical diatomicChlorine = Chemical.Builder.newInstance().add(Element.CL, 2).build();
        ChemicalEquation identity = ChemicalEquation.Builder.newInstance()
                .addReactant(atomicChlorine)
                .addProduct(diatomicChlorine)
                .build();
        assertThat(BalancedChemicalEquation.balance(identity).toString()).isEqualTo("2 Cl => Cl2");
    }

    @Test
    public void testBalance_complex() throws Exception
    {

        Chemical glucose = Chemical.Builder.newInstance()
                .add(Element.C, 6)
                .add(Element.H, 12)
                .add(Element.O, 6)
                .build();

        ChemicalEquation respiration = ChemicalEquation.Builder.newInstance()
                .addReactant(glucose)
                .addReactant(oxygen)
                .addProduct(carbonDioxide)
                .addProduct(water)
                .build();

        assertThat(BalancedChemicalEquation.balance(respiration).toString())
                .isEqualTo("C6H12O6 + 6 O2 => 6 CO2 + 6 H2O");
    }

    // TODO: rework the balancer to handle cases with big coefficients. (Inspection/Linear Algebra?)
    @Test
    public void testBalance_bigCoefficients_fail() throws Exception
    {
        Chemical hydrocarbon = Chemical.Builder.newInstance()
                .add(Element.C, 30)
                .add(Element.H, 62)
                .build();

        ChemicalEquation boom = ChemicalEquation.Builder.newInstance()
                .addReactant(hydrocarbon)
                .addReactant(oxygen)
                .addProduct(carbonDioxide)
                .addProduct(water)
                .build();

        try
        {
            BalancedChemicalEquation.balance(boom);
            Assert.fail();
        }
        catch(Exception ex)
        {
            // pass
        }
    }
}
