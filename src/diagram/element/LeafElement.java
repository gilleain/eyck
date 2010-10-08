package diagram.element;

import java.awt.Color;

import javax.vecmath.Point2d;

import diagram.AbstractDiagramElement;

/**
 * A diagram element that is given a center when constructed.
 * 
 * @author maclean
 *
 */
public class LeafElement extends AbstractDiagramElement {
    
    public Point2d center;
    
    public Color color;
    
    public LeafElement(Point2d center) {
        this.center = center;
        this.color = Color.BLACK;
    }

    @Override
    public Point2d getCenter() {
        return center;
    }
    
    public Color getColor() {
        return color;
    }

}
