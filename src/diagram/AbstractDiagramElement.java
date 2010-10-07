package diagram;

import java.awt.geom.Rectangle2D;

import diagram.element.ElementSet;
import diagram.element.IDiagramElement;
import diagram.element.LeafElement;

/**
 * The base class for {@link LeafElement}s and {@link ElementSet}s.
 *  
 * @author maclean
 *
 */
public abstract class AbstractDiagramElement implements IDiagramElement {
   
    public Rectangle2D bounds;
    
    @Override
    public Rectangle2D getBounds() {
        return bounds;
    }

}
