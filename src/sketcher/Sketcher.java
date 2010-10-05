package sketcher;

import java.awt.geom.Rectangle2D;

import diagram.Diagram;

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
     * Create a sketch of the model object as a diagram.
     * 
     * @param modelObject the model object to sketch
     * @param canvas the canvas to sketch on
     * @return a diagram
     */
    public Diagram<S> sketch(T modelObject, Rectangle2D canvas);

}
