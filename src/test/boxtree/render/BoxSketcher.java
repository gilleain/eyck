package test.boxtree.render;

import java.awt.geom.Rectangle2D;

import diagram.IDiagram;
import sketcher.AbstractSketcher;
import test.boxtree.diagram.BoxElement;
import test.boxtree.model.Box;

public class BoxSketcher extends AbstractSketcher<Box, BoxElement> {

    @Override
    public IDiagram<BoxElement> sketch(Box modelObject, Rectangle2D canvas) {
        return new BoxElement(modelObject.rectangle);
    }

    @Override
    public Rectangle2D getModelBounds(Box model) {
        return model.rectangle; // heh
    }

}
