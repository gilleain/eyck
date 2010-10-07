package diagram.element;

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
    
    public LeafElement(Point2d center) {
        this.center = center;
    }

    @Override
    public Point2d getCenter() {
        return center;
    }

}
