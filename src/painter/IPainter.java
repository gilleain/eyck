package painter;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

public interface IPainter<T> {

    public void paint(T object, Rectangle2D canvas);
    
    public void paint(T object, Point2d center);
}
