package diagram.element;

import java.awt.Color;

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
        this(center, width, height, Color.BLACK);
    }
    
    public RectangleElement(Point2d center, double width, double height, Color color) {
        super(center);
        this.width = width;
        this.height = height;
        this.color = color;
    }

}
