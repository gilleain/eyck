package sketcher;

import diagram.DiagramTree;

public interface CompositeSketcher<T, S> {
    
    public DiagramTree<S> sketch(T compositeObject);
    
}
