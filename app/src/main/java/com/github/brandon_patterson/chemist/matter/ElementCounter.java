package com.github.brandon_patterson.chemist.matter;

import java.util.HashMap;
import java.util.Map;

public class ElementCounter
{
    private ElementCounter() {}

    public static Map<Element, Integer> getCounts(Chemical chemical)
    {
        ElementCountingVisitor visitor = new ElementCountingVisitor();
        chemical.accept(visitor);
        return visitor.counts;
    }

    private static class ElementCountingVisitor implements ChemicalVisitor
    {
        private Map<Element, Integer> counts = new HashMap<>();
        private int multiplier = 1;

        @Override
        public void visit(Element element, int count) {
            int currentValue = counts.containsKey(element) ? counts.get(element) : 0;
            counts.put(element, currentValue + count * multiplier);
        }

        @Override
        public void visit(Chemical polyatom, int count) {
            multiplier *= count;
            polyatom.accept(this);
            multiplier /= count;
        }
    }
}
