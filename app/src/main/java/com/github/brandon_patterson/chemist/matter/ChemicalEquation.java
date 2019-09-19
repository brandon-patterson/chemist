package com.github.brandon_patterson.chemist.matter;

import com.github.brandon_patterson.chemist.utils.StringUtils;
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
        sb.append(StringUtils.join(" + ", reactants));
        sb.append(" => ");
        sb.append(StringUtils.join(" + ", products));
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
