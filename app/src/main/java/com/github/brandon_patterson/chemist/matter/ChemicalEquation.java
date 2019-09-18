package com.github.brandon_patterson.chemist.matter;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class ChemicalEquation
{
    private ImmutableList<Chemical> reactants;
    private ImmutableList<Chemical> products;

    private ChemicalEquation(List<Chemical> reactants, List<Chemical> products)
    {
        this.reactants = ImmutableList.copyOf(reactants);
        this.products = ImmutableList.copyOf(products);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for(Chemical c : reactants)
        {
            sb.append(c);
            sb.append(" + ");
        }
        sb.delete(sb.length() - 3, sb.length());

        sb.append(" => ");

        for(Chemical c : products)
        {
            sb.append(c);
            sb.append(" + ");
        }
        sb.delete(sb.length() - 3, sb.length());

        return sb.toString();
    }

    public static class Builder
    {
        List<Chemical> reactants = new ArrayList<>();
        List<Chemical> products = new ArrayList<>();

        public static Builder getInstance()
        {
            return new Builder();
        }

        private Builder(){}

        public Builder addReactant(Chemical reactant)
        {
            reactants.add(reactant);
            return this;
        }

        public Builder addProduct(Chemical product)
        {
            products.add(product);
            return this;
        }

        public ChemicalEquation build()
        {
            return new ChemicalEquation(reactants, products);
        }
    }
}
