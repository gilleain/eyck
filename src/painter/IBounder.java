package painter;

import java.awt.geom.Rectangle2D;

/**
 * Calculates the bounding rectangle of objects that are going to be drawn. 
 * 
 * @author maclean
 *
 * @param <T> A model object that has a 2D bounding rectangle.
 */
public interface IBounder<T> {
    
    public Rectangle2D getBounds(T object);

}
