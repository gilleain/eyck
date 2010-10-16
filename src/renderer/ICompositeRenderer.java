package renderer;

import java.awt.geom.Rectangle2D;

import painter.IPainter;
import sketcher.CompositeSketcher;

public interface ICompositeRenderer<T> {
    
    public void setCompositeSketcher(CompositeSketcher sketcher);
    
    public void setPainter(IPainter painter);

    public void render(T object, Rectangle2D canvas);
}