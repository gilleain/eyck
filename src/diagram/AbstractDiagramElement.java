package diagram;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import diagram.element.ElementList;
import diagram.element.IDiagramElement;
import diagram.element.LeafElement;

/**
 * The base class for {@link LeafElement}s and {@link ElementList}s.
 *  
 * @author maclean
 *
 */
public abstract class AbstractDiagramElement implements IDiagramElement {
   
    public Rectangle2D bounds;
    
    @Override
    public Rectangle2D getBounds() {
        if (bounds == null) {
            Point2d center = getCenter();
            return new Rectangle2D.Double(center.x, center.y, 0, 0);
        }
        return bounds;
    }

}
