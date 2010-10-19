package diagram.element;

import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

public interface IDiagramElement {
    
    public Rectangle2D getBounds();
    
    public Point2d getCenter();
    
    public void add(IDiagramElement child);
    
    public List<IDiagramElement> getChildren();
    
    public int size();

}
