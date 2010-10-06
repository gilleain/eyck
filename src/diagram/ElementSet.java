package diagram;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.vecmath.Point2d;

public class ElementSet extends AbstractDiagramElement implements Iterable<IDiagramElement>{
    
    private Set<IDiagramElement> children;

    public ElementSet() {
        children = new HashSet<IDiagramElement>();
    }

    @Override
    public Point2d getCenter() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<IDiagramElement> iterator() {
        return children.iterator();
    }
    
}
