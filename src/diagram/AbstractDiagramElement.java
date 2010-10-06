package diagram;

import java.awt.geom.Rectangle2D;

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
