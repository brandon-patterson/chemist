package com.github.brandon_patterson.chemist.matter;

import java.util.ArrayList;
import java.util.List;

public class ChemicalEquation
{
    private List<Chemical> reactants;
    private List<Chemical> products;

    public ChemicalEquation()
    {
        reactants = new ArrayList<>();
        products = new ArrayList<>();
    }

    public void addReactant(Chemical reactant)
    {
        reactants.add(reactant);
    }

    public void addProduct(Chemical product)
    {
        products.add(product);
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
}
