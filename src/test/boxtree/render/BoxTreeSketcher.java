package test.boxtree.render;

import java.awt.geom.Rectangle2D;

import diagram.DiagramTree;
import diagram.IDiagram;
import sketcher.CompositeSketcher;
import test.boxtree.diagram.BoxElement;
import test.boxtree.model.BoxTree;

public class BoxTreeSketcher implements CompositeSketcher<BoxTree, BoxElement> {
    
    private BoxSketcher boxSketcher;
    
    public BoxTreeSketcher() {
        boxSketcher = new BoxSketcher();
    }

    @Override
    public DiagramTree<BoxElement> sketch(BoxTree boxTree) {
        DiagramTree<BoxElement> boxDiagram = new DiagramTree<BoxElement>();
        sketch(boxTree, boxDiagram);
        return boxDiagram;
    }
    
    private void sketch(BoxTree node, DiagramTree<BoxElement> diagram) {
        if (node.leaf != null) {
            IDiagram<BoxElement> leafDiagram = boxSketcher.sketch(node.leaf);
            diagram.addDiagram(leafDiagram);
        }
        
        for (BoxTree child : node.children) {
            sketch(child, diagram);
        }
    }

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
            } else {
                bounds.add(model.leaf.rectangle);
            }
        } else {
            for (BoxTree child : model.children) {
                getModelBounds(child, bounds);
            }
        }
    }
}
