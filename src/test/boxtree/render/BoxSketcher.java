package test.boxtree.render;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import sketcher.AbstractSketcher;
import test.boxtree.diagram.BoxElement;
import test.boxtree.model.Box;

public class BoxSketcher extends AbstractSketcher<Box, BoxElement> {

    @Override
    public BoxElement sketch(Box modelObject) {
        final BoxElement element = new BoxElement(modelObject.rectangle);
//        I diagram = new IDiagram<BoxElement>() {
//
//            @Override
//            public List<BoxElement> getElements() {
//                List<BoxElement> elements = new ArrayList<BoxElement>();
//                elements.add(element);
//                return elements;
//            }
//
//            @Override
//            public void add(BoxElement element) {
//                // TODO Auto-generated method stub
//                
//            }
//
//            @Override
//            public void addAll(List<BoxElement> elements) {
//                // TODO Auto-generated method stub
//                
//            }
//              
//        };
//        return diagram;
        return null; // TODO XXX FIXME
    }

    @Override
    public Rectangle2D getModelBounds(Box model) {
        return model.rectangle; // heh
    }

}
