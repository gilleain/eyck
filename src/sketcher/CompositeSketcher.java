package sketcher;

import java.awt.geom.Rectangle2D;

import diagram.DiagramTree;

public interface CompositeSketcher<T, S> {
    
    public DiagramTree<S> sketch(T compositeObject, Rectangle2D canvas);

}
