package com.github.brandon_patterson.chemist.matter;

import junit.framework.Assert;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class ChemicalTest {

    @Test
    public void testAccept() throws UnsupportedOperationException, IllegalArgumentException
    {
        // Nonsense molecule H(C2(O3N4)5)6 with 223 atoms
        Chemical complexMolecule = Chemical.Builder.newInstance()
                .add(Element.H)
                .add(Chemical.Builder.newInstance()
                        .add(Element.C, 2)
                        .add(Chemical.Builder.newInstance()
                                .add(Element.O, 3)
                                .add(Element.N, 4)
                                .build(), 5)
                        .build(), 6)
                .build();

        // needs to be a final array because an inner class can't modify an int counter directly
        final int[] atomCount = {0};

        ChemicalVisitor visitor = new ChemicalVisitor() {
            int multiplier = 1;
            @Override
            public void visit(Element element, int count) {
                atomCount[0] += count * multiplier;
            }

            @Override
            public void visit(Chemical polyatom, int count) {
                multiplier *= count;
                polyatom.accept(this);
                multiplier /= count;
            }
        };

        complexMolecule.accept(visitor);
        assertThat(atomCount[0]).isEqualTo(223);
    }

    @Test
    public void testBuilder_buildEmptyChemical_throws() throws UnsupportedOperationException
    {
        try
        {
            Chemical.Builder.newInstance().build();
            Assert.fail("Expected UnsupportedOperationException, but none was thrown");
        }
        catch (UnsupportedOperationException ex)
        {
            // pass
        }
        catch (Exception ex)
        {
            String exType = ex.getClass().getSimpleName();
            Assert.fail("Expected UnsupportedOperationException, but got " + exType);
        }
    }

    @Test
    public void testBuilder_addElement_requiresPositiveCounts() throws IllegalArgumentException
    {
        try
        {
            Chemical.Builder.newInstance().add(Element.AU, 0);
            Assert.fail("Expected IllegalArgumentException, but none was thrown");
        }
        catch (IllegalArgumentException ex)
        {
            // pass
        }
        catch (Exception ex)
        {
            String exType = ex.getClass().getSimpleName();
            Assert.fail("Expected IllegalArgumentException, but got " + exType);
        }
    }

    @Test
    public void testBuilder_addPolyatom_requairesPositiveCounts() throws IllegalArgumentException
    {
        try
        {
            Chemical polyatom = Chemical.Builder.newInstance()
                    .add(Element.O)
                    .add(Element.H)
                    .build();
            Chemical.Builder.newInstance().add(polyatom, 0);
            Assert.fail("Expected IllegalArgumentException, but none was thrown");
        }
        catch (IllegalArgumentException ex)
        {
            // pass
        }
        catch (Exception ex)
        {
            String exType = ex.getClass().getSimpleName();
            Assert.fail("Expected IllegalArgumentException, but got " + exType);
        }
    }

    @Test
    public void testBuilder_createsImmutableChemicals(){
        Chemical.Builder builder = Chemical.Builder.newInstance().add(Element.H, 2);
        Chemical hydrogen = builder.build();
        builder.add(Element.O);
        Chemical water = builder.build();
        assertThat(hydrogen.toString()).isEqualTo("H2");
    }
}
