package com.github.brandon_patterson.chemist.matter;

import android.content.Context;
import android.content.res.Resources;

import com.github.brandon_patterson.chemist.R;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ElementTest {

    @Mock
    Context mockContext;

    @Mock
    Resources mockResources;

    @Before
    public void setup()
    {
        when(mockContext.getResources()).thenReturn(mockResources);
    }

    @Test
    public void getAtomicNumber()
    {
        assertThat(Element.O.getAtomicNumber()).isEqualTo(8);
    }

    @Test
    public void fromAtomicNumber_validInput() throws NoSuchElementException
    {
        assertThat(Element.fromAtomicNumber(6)).isEqualTo(Element.C);
    }

    @Test
    public void fromAtomicNumber_invalidInput()
    {
        String expectedExceptionName = NoSuchElementException.class.getSimpleName();
        try {
            Element.fromAtomicNumber(999);
            Assert.fail("Expected " + expectedExceptionName + ", but no exception was thrown.");
        }
        catch (NoSuchElementException ex)
        {
            // pass
        }
        catch (Exception ex)
        {
            String exType = ex.getClass().getSimpleName();
            Assert.fail("Expected " + expectedExceptionName + ", but got " + exType);
        }
    }

    @Test
    public void getSymbol()
    {
        when(mockResources.getString(R.string.element_symbol_007)).thenReturn("N");
        assertThat(Element.N.getSymbol(mockContext)).isEqualTo("N");
    }

    @Test
    public void fromSymbol_validInput() throws NoSuchElementException
    {
        when(mockResources.getString(R.string.element_symbol_079)).thenReturn("Au");
        assertThat(Element.fromSymbol("Au", mockContext)).isEqualTo(Element.AU);
        assertThat(Element.fromSymbol("au", mockContext)).isEqualTo(Element.AU);
        assertThat(Element.fromSymbol("AU", mockContext)).isEqualTo(Element.AU);
    }

    @Test
    public void fromSymbol_invalidInput() throws NoSuchElementException
    {
        String expectedExceptionName = NoSuchElementException.class.getSimpleName();
        try {
            Element.fromSymbol("Xx", mockContext);
            Assert.fail("Expected " + expectedExceptionName + ", but no exception was thrown.");
        }
        catch (NoSuchElementException ex)
        {
            // pass
        }
        catch (Exception ex)
        {
            String exType = ex.getClass().getSimpleName();
            Assert.fail("Expected " + expectedExceptionName + ", but got " + exType);
        }
    }

    @Test
    public void getName()
    {
        when(mockResources.getString(R.string.element_name_026)).thenReturn("Iron");
        assertThat(Element.FE.getName(mockContext)).isEqualTo("Iron");
    }

    @Test
    public void fromName_validInput() throws NoSuchElementException
    {
        when(mockResources.getString(R.string.element_name_092)).thenReturn("Uranium");
        assertThat(Element.fromName("Uranium", mockContext)).isEqualTo(Element.U);
        assertThat(Element.fromName("uranium", mockContext)).isEqualTo(Element.U);
        assertThat(Element.fromName("URANIUM", mockContext)).isEqualTo(Element.U);
    }

    @Test
    public void fromName_invalidInput()
    {
        String expectedExceptionName = NoSuchElementException.class.getSimpleName();
        try {
            Element.fromName("Adamantium", mockContext);
            Assert.fail("Expected " + expectedExceptionName + ", but no exception was thrown.");
        }
        catch (NoSuchElementException ex)
        {
            // pass
        }
        catch (Exception ex)
        {
            String exType = ex.getClass().getSimpleName();
            Assert.fail("Expected " + expectedExceptionName + ", but got " + exType);
        }
    }
}
