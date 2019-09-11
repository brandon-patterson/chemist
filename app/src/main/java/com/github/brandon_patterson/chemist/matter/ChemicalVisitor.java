package com.github.brandon_patterson.chemist.matter;

public interface ChemicalVisitor {
    void visit(Element element, int count);
    void visit(Chemical polyatom, int count);
}
