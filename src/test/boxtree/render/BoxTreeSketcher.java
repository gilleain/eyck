package test.boxtree.render;

import java.awt.geom.Rectangle2D;

import diagram.Diagram;
import sketcher.AbstractSketcher;
import test.boxtree.diagram.BoxElement;
import test.boxtree.model.BoxTree;

public class BoxTreeSketcher extends AbstractSketcher<BoxTree, BoxElement> {

    @Override
    public Diagram<BoxElement> sketch(BoxTree boxTree, Rectangle2D canvas) {
        Diagram<BoxElement> boxDiagram = new BoxElement();
        return boxDiagram;
    }

    @Override
    public Rectangle2D getModelBounds(BoxTree model) {
        // TODO Auto-generated method stub
        return null;
    }

}
