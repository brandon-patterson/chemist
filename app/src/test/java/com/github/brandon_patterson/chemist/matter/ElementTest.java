package com.github.brandon_patterson.chemist.matter;

import android.content.Context;
import android.content.res.Resources;

import com.github.brandon_patterson.chemist.R;

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
    public void fromAtomicNumber() throws NoSuchElementException
    {
        assertThat(Element.fromAtomicNumber(6)).isEqualTo(Element.C);
    }

    @Test
    public void getSymbol()
    {
        when(mockResources.getString(R.string.element_symbol_007)).thenReturn("N");
        assertThat(Element.N.getSymbol(mockContext)).isEqualTo("N");
    }

    @Test
    public void fromSymbol() throws NoSuchElementException
    {
        when(mockResources.getString(R.string.element_symbol_079)).thenReturn("Au");
        assertThat(Element.fromSymbol("Au", mockContext)).isEqualTo(Element.AU);
        assertThat(Element.fromSymbol("au", mockContext)).isEqualTo(Element.AU);
        assertThat(Element.fromSymbol("AU", mockContext)).isEqualTo(Element.AU);
    }

    @Test
    public void getName()
    {
        when(mockResources.getString(R.string.element_name_026)).thenReturn("Iron");
        assertThat(Element.FE.getName(mockContext)).isEqualTo("Iron");
    }

    @Test
    public void fromName() throws NoSuchElementException
    {
        when(mockResources.getString(R.string.element_name_092)).thenReturn("Uranium");
        assertThat(Element.fromName("Uranium", mockContext)).isEqualTo(Element.U);
        assertThat(Element.fromName("uranium", mockContext)).isEqualTo(Element.U);
        assertThat(Element.fromName("URANIUM", mockContext)).isEqualTo(Element.U);
    }
}
