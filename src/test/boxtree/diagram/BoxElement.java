package test.boxtree.diagram;

import java.awt.geom.Rectangle2D;
import java.util.List;


public class BoxElement {
    
    public Rectangle2D bounds;
    
    public BoxElement() {
        this(null);
    }
    
    public BoxElement(Rectangle2D bounds) {
        this.bounds = bounds;
    }

    public List<BoxElement> getChildren() {
        // TODO Auto-generated method stub
        return null;
    }

    public void add(BoxElement leafDiagram) {
        // TODO Auto-generated method stub
        
    }

}
