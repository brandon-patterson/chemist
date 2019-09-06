package com.github.brandon_patterson.chemist.matter;

public class ChemicalFormulaPrinter {

    public static String getFormula(Chemical chemical)
    {
        Visitor visitor = new Visitor();
        chemical.accept(visitor);
        return visitor.toString();
    }

    private static class Visitor implements ChemicalVisitor {
        private StringBuilder builder = new StringBuilder();
        private int nestingLevel = 0;

        @Override
        public void visit(Element element, int count) {
            builder.append(element.getSymbol());
            if (count > 1) {
                builder.append(count);
            }
        }

        @Override
        public void visit(Chemical polyatom, int count) {
            nestingLevel += 1;
            if (count == 1) {
                polyatom.accept(this);
            } else {
                builder.append(nestingLevel % 2 == 1 ? "(" : "[");
                polyatom.accept(this);
                builder.append(nestingLevel % 2 == 1 ? ")" : "]");
                builder.append(count);
            }
            nestingLevel -= 1;
        }

        @Override
        public String toString()
        {
            return builder.toString();
        }
    }
}
