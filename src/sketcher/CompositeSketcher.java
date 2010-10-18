package sketcher;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import diagram.DiagramTree;

public interface CompositeSketcher<T, S> {
    
    public DiagramTree<S> sketch(T compositeObject, Rectangle2D canvas);
    
    public DiagramTree<S> sketch(T compositeObject, Point2d point);

}
