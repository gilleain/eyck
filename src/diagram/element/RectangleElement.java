package diagram.element;

import javax.vecmath.Point2d;


/**
 * A rectangle.
 * 
 * @author maclean
 *
 */
public class RectangleElement extends LeafElement {
    
    public double width;
    
    public double height;
    
    public RectangleElement(Point2d center, double width, double height) {
        super(center);
        this.width = width;
        this.height = height;
    }

}
