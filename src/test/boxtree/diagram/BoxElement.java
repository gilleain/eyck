package test.boxtree.diagram;

import java.awt.geom.Rectangle2D;


public class BoxElement {
    
    public Rectangle2D bounds;
    
    public BoxElement() {
        this(null);
    }
    
    public BoxElement(Rectangle2D bounds) {
        this.bounds = bounds;
    }

}
