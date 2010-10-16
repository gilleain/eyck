package painter;

import java.awt.geom.Rectangle2D;

public interface ICompositePainter<T> {
    
    public void paint(T compositeDiagram, Rectangle2D canvas);

}
