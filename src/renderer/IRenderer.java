package renderer;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

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
    
    /**
     * Render the model to fit into the canvas.
     * 
     * @param model the object to render
     * @param canvas the area defined as the canvas
     */
    public void render(T model, Rectangle2D canvas);
    
    /**
     * Render the model at some 'natural' scale, centered on the point.
     * 
     * @param model the object to render
     * @param center the central point to render at
     */
    public void render(T model, Point2d center);

}
