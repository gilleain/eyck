package diagram.element;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

public interface IDiagramElement {
    
    public Rectangle2D getBounds();
    
    public Point2d getCenter();

}
