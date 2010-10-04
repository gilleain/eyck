package renderer;

import java.awt.geom.Rectangle2D;

import painter.IPainter;
import sketcher.Sketcher;

/**
 * A renderer composes a sketcher and a painter to produce an image from a
 * model, via a diagram.
 * 
 * @author maclean
 *
 * @param <T>
 */
public interface IRenderer<T> {
    
    public void setSketcher(Sketcher sketcher);
    
    public void setPainter(IPainter painter);
    
    public void render(T model, Rectangle2D canvas);

}
