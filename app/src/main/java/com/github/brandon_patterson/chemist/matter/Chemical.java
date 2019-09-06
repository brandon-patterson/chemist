package com.github.brandon_patterson.chemist.matter;

import java.util.ArrayList;
import java.util.List;

public class Chemical
{
    private List<ChemicalNode> nodes;

    private Chemical (List<ChemicalNode> nodes)
    {
        this.nodes = nodes;
    }

    public void accept(ChemicalVisitor visitor)
    {
        for(ChemicalNode node : nodes)
        {
            node.accept(visitor);
        }
    }

    @Override
    public String toString()
    {
        return ChemicalFormulaPrinter.getFormula(this);
    }

    private static abstract class ChemicalNode
    {
        protected int count;
        public abstract void accept(ChemicalVisitor visitor);
    }

    private static class ElementNode extends ChemicalNode
    {
        private Element element;

        ElementNode(Element element, int count)
        {
            this.element = element;
            this.count = count;
        }

        public void accept(ChemicalVisitor visitor)
        {
            visitor.visit(element, count);
        }
    }

    private static class PolyatomNode extends ChemicalNode
    {
        private Chemical polyatom;

        PolyatomNode(Chemical chemical, int count)
        {
            polyatom = chemical;
            this.count = count;
        }

        public void accept(ChemicalVisitor visitor)
        {
            visitor.visit(polyatom, count);
        }
    }

    public static class Builder
    {
        public static Builder newInstance()
        {
            return new Builder();
        }

        private List<ChemicalNode> nodes = new ArrayList<>();

        private Builder() {}

        public Builder add(Element element) throws IllegalArgumentException
        {
            return add(element,1);
        }

        public Builder add(Element element, int count) throws IllegalArgumentException
        {
            if (count < 1)
            {
                throw new IllegalArgumentException("Count must be positive, was " + count);
            }
            return add(new ElementNode(element, count));
        }

        public Builder add(Chemical polyatom) throws IllegalArgumentException
        {
            return add(polyatom, 1);
        }

        public Builder add(Chemical polyatom, int count) throws IllegalArgumentException
        {
            if (count < 1)
            {
                throw new IllegalArgumentException("Count must be positive, was " + count);
            }
            return add(new PolyatomNode(polyatom, count));
        }

        private Builder add(ChemicalNode node)
        {
            nodes.add(node);
            return this;
        }

        public Chemical build() throws UnsupportedOperationException
        {
            if (nodes.size() == 0)
            {
                throw new UnsupportedOperationException("Cannot build an empty Chemical");
            }

            return new Chemical(nodes);
        }
    }
}
