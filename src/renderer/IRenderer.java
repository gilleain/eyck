package renderer;

import java.awt.geom.Rectangle2D;

import painter.IPainter;
import sketcher.Sketcher;

public interface IRenderer<T> {
    
    public void setSketcher(Sketcher sketcher);
    
    public void setPainter(IPainter painter);
    
    public void render(T model, Rectangle2D canvas);

}
