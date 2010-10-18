package sketcher;

import diagram.IDiagram;

/**
 * Produces diagrams from model objects.
 * 
 * @author maclean
 *
 * @param <T> the model type
 * @param <S> the diagram type
 */
public interface Sketcher<T, S> {
    
    /**
     * Create a sketch of the model object as a diagram, centered on the origin.
     * 
     * @param modelObject the model object to sketch
     * @param canvas the canvas to sketch on
     * @return a diagram
     */
    public IDiagram<S> sketch(T modelObject);

}