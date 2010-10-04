package sketcher;

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
    
    public Diagram<S> sketch(T modelObject, double scale);

}
