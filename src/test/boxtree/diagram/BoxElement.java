package test.boxtree.diagram;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import diagram.IDiagram;


public class BoxElement implements IDiagram<BoxElement> {
    
    private List<BoxElement> children;
    
    public Rectangle2D bounds;
    
    public BoxElement() {
        this(null);
    }
    
    public BoxElement(Rectangle2D bounds) {
        this.bounds = bounds;
        children = new ArrayList<BoxElement>();
    }

    @Override
    public List<BoxElement> getElements() {
        return children;
    }

    @Override
    public void add(BoxElement element) {
        children.add(element);
    }

    @Override
    public void addAll(List<BoxElement> elements) {
        children.addAll(elements);
    }

}
