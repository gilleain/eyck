package diagram.element;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.vecmath.Point2d;

import diagram.AbstractDiagramElement;

public class ElementSet extends AbstractDiagramElement implements Iterable<IDiagramElement>{
    
    private Set<IDiagramElement> children;

    public ElementSet() {
        children = new HashSet<IDiagramElement>();
    }

    @Override
    public Point2d getCenter() {
        Rectangle2D bounds = calculateBounds();
        return new Point2d(bounds.getCenterX(), bounds.getCenterY());
    }
    
    public Rectangle2D calculateBounds() {
        Rectangle2D bounds = null;
        for (IDiagramElement child : children) {
            Rectangle2D childBounds = child.getBounds();
            if (bounds == null) {
                bounds = (Rectangle2D) childBounds.clone();
            } else {
                bounds.add(childBounds);
            }
        }
        return bounds;
    }

    @Override
    public Iterator<IDiagramElement> iterator() {
        return children.iterator();
    }
    
    public void add(IDiagramElement element) {
        children.add(element);
    }
    
    public List<IDiagramElement> getElements() {
        return new ArrayList<IDiagramElement>(children);
    }

    @Override
    public int size() {
        int totalSize = 0;
        for (IDiagramElement child : children) {
            totalSize += child.size();
        }
        return totalSize;
    }

    @Override
    public List<IDiagramElement> getChildren() {
        return new ArrayList<IDiagramElement>(children);
    }
    
}
