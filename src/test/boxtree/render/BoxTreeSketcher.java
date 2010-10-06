package test.boxtree.render;

import java.awt.geom.Rectangle2D;

import diagram.IDiagram;
import sketcher.AbstractSketcher;
import test.boxtree.diagram.BoxElement;
import test.boxtree.model.BoxTree;

public class BoxTreeSketcher extends AbstractSketcher<BoxTree, BoxElement> {
    
    private BoxSketcher boxSketcher;
    
    public BoxTreeSketcher() {
        boxSketcher = new BoxSketcher();
    }

    @Override
    public IDiagram<BoxElement> sketch(BoxTree boxTree, Rectangle2D canvas) {
        IDiagram<BoxElement> boxDiagram = new BoxElement();
        sketch(boxTree, boxDiagram, canvas);
        return boxDiagram;
    }
    
    private void sketch(BoxTree node, IDiagram<BoxElement> diagram, Rectangle2D canvas) {
        if (node.leaf != null) {
            IDiagram<BoxElement> leafDiagram = boxSketcher.sketch(node.leaf, canvas);
            diagram.addAll(leafDiagram.getElements());
        }
        
        for (BoxTree child : node.children) {
            diagram.add(new BoxElement(null));  /// XXX
            sketch(child, diagram, canvas);
        }
    }

    @Override
    public Rectangle2D getModelBounds(BoxTree model) {
        // pass in null so that the union is made correctly
        Rectangle2D bounds = null;
        getModelBounds(model, bounds);
        return bounds;
    }
    
    private void getModelBounds(BoxTree model, Rectangle2D bounds) {
        if (model.leaf != null) {
            if (bounds == null) {
                bounds = (Rectangle2D) model.leaf.rectangle.clone();
            }
        } else {
            
        }
    }

}
