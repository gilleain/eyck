package diagram.element;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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
    
    @Override
    public void add(IDiagramElement child) {
        // TODO - throw Exception?
    }

    @Override
    public int size() {
        return 1;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public List<IDiagramElement> getChildren() {
        return new ArrayList<IDiagramElement>();
    }

}
