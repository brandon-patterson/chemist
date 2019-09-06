package com.github.brandon_patterson.chemist.matter;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class ChemicalFormulaPrinterTest {
    
    @Test
    public void testGetFormula_simpleCase() throws Exception {
        Chemical water = Chemical.Builder.newInstance()
                .add(Element.H, 2)
                .add(Element.O)
                .build();

        assertThat(ChemicalFormulaPrinter.getFormula(water)).isEqualTo("H2O");
    }

    @Test
    public void testGetFormula_duplicateElements() throws Exception {
        Chemical formicAcid = Chemical.Builder.newInstance()
                .add(Element.H)
                .add(Element.C)
                .add(Element.O)
                .add(Element.O)
                .add(Element.H)
                .build();

        assertThat(ChemicalFormulaPrinter.getFormula(formicAcid)).isEqualTo("HCOOH");
    }

    @Test
    public void testGetFormula_singlePolyatom() throws Exception
    {
        Chemical sulphuricAcid = Chemical.Builder.newInstance()
                .add(Element.H, 2)
                .add(getSulfate())
                .build();

        assertThat(ChemicalFormulaPrinter.getFormula(sulphuricAcid)).isEqualTo("H2SO4");
    }

    @Test
    public void testGetFormula_multiplePolyatoms() throws Exception
    {
        Chemical ammoniumOxide = Chemical.Builder.newInstance()
                .add(Chemical.Builder.newInstance()
                        .add(Element.N)
                        .add(Element.H, 4)
                        .build(), 2)
                .add(Element.O)
                .build();

        assertThat(ChemicalFormulaPrinter.getFormula(ammoniumOxide)).isEqualTo("(NH4)2O");
    }

    @Test
    public void testGetFormula_nestedPolyatoms() throws Exception
    {
        // [C(NH2)3]2SO4
        // (May not be a correct formula, but the string construction is still valid)
        Chemical guanidineSulfate = Chemical.Builder.newInstance()
                .add(Chemical.Builder.newInstance()
                        .add(Element.C)
                        .add(Chemical.Builder.newInstance()
                                .add(Element.N)
                                .add(Element.H, 2)
                                .build(), 3)
                        .build(),2)
                .add(getSulfate())
                .build();

        assertThat(ChemicalFormulaPrinter.getFormula(guanidineSulfate))
                .isEqualTo("(C[NH2]3)2SO4");
    }

    private Chemical getSulfate() throws Exception
    {
        return Chemical.Builder.newInstance()
                .add(Element.S)
                .add(Element.O, 4)
                .build();
    }
}
