package com.github.brandon_patterson.chemist.matter;

import com.github.brandon_patterson.chemist.utils.MathUtils;
import com.github.brandon_patterson.chemist.utils.StringUtils;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalancedChemicalEquation extends ChemicalEquation {

    private ImmutableList<Integer> coefficients;

    private BalancedChemicalEquation(ChemicalEquation equation, List<Integer> coefficients)
    {
        super(equation.reactants, equation.products);
        this.coefficients = ImmutableList.copyOf(coefficients);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        List<String> balancedReactants = new ArrayList<>();
        List<String> balancedProducts = new ArrayList<>();

        for (int i = 0; i < reactants.size(); i++)
        {
            int coeff = coefficients.get(i);
            String coeffStr = coeff > 1 ? coeff + " " : "";
            balancedReactants.add(coeffStr + reactants.get(i));
        }
        for (int i = 0; i < products.size(); i++)
        {
            int coeff = coefficients.get(reactants.size() + i);
            String coeffStr = coeff > 1 ? coeff + " " : "";
            balancedProducts.add(coeffStr + products.get(i));
        }

        sb.append(StringUtils.join(" + ", balancedReactants));
        sb.append(" => ");
        sb.append(StringUtils.join(" + ", balancedProducts));

        return sb.toString();
    }

    public static BalancedChemicalEquation balance(ChemicalEquation equation) throws Exception
    {
        //TODO: Clean up brute force implementation and remove artificial max coefficient
        int numEntries = equation.reactants.size() + equation.products.size();

        List<Integer> coefficients = new ArrayList<>();
        for (int i = 0; i < numEntries; i++)
        {
            coefficients.add(1);
        }

        List<Map<Element, Integer>> reactantElementCounts = new ArrayList<>();
        List<Map<Element, Integer>> productElementCounts = new ArrayList<>();

        for(Chemical c : equation.reactants)
        {
            reactantElementCounts.add(ElementCounter.getCounts(c));
        }
        for(Chemical c : equation.products)
        {
            productElementCounts.add(ElementCounter.getCounts(c));
        }

        int maxCount = 1;
        while (maxCount <= 20) {

            if(coefficients.contains(maxCount) && MathUtils.gcd(coefficients) == 1)
            {
                if (isBalanced(reactantElementCounts, productElementCounts, coefficients))
                {
                    return new BalancedChemicalEquation(equation, coefficients);
                }
            }

            int incrementIdx = 0;
            while (incrementIdx < numEntries && coefficients.get(incrementIdx) == maxCount)
            {
                coefficients.set(incrementIdx, 1);
                incrementIdx++;
            }

            if (incrementIdx < numEntries)
            {
                coefficients.set(incrementIdx, coefficients.get(incrementIdx) + 1);
            }
            else
            {
                for (int i = 0; i < numEntries; i++) {
                    coefficients.set(i, 1);
                }
                maxCount++;
                continue;
            }

        }

        throw new Exception("Failed to balance " + equation.toString());
    }

    private static boolean isBalanced(
            List<Map<Element, Integer>> reactantCounts,
            List<Map<Element, Integer>> productCounts,
            List<Integer> coefficients)
    {
        Map<Element, Integer> totalReactantCounts = new HashMap<>();
        Map<Element, Integer> totalProductCounts = new HashMap<>();

        for(int i = 0; i < reactantCounts.size(); i++)
        {
            Map<Element, Integer> reactant = reactantCounts.get(i);
            int coefficient = coefficients.get(i);
            for(Element e : reactant.keySet())
            {
                int existingCount =
                        totalReactantCounts.containsKey(e) ? totalReactantCounts.get(e) : 0;
                totalReactantCounts.put(e, existingCount + reactant.get(e) * coefficient);
            }
        }

        for(int i = 0; i < productCounts.size(); i++)
        {
            Map<Element, Integer> product = productCounts.get(i);
            int coefficient = coefficients.get(reactantCounts.size() + i);
            for(Element e : product.keySet())
            {
                int existingCount =
                        totalProductCounts.containsKey(e) ? totalProductCounts.get(e) : 0;
                totalProductCounts.put(e, existingCount + product.get(e) * coefficient);
            }
        }

        return totalReactantCounts.equals(totalProductCounts);
    }
}
