package divide;

import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 * A divider breaks a canvas up into parts.
 * 
 * @author maclean
 *
 */
public interface IDivider {
    
    public List<Rectangle2D> divide(Rectangle2D canvas, int parts);
    
    public void addSubDivider(IDivider subDivider);
    
    public List<IDivider> getSubDividers();

}
