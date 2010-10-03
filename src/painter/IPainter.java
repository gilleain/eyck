package painter;

import java.awt.geom.Rectangle2D;

public interface IPainter<T> {

    public void paint(T object, Rectangle2D canvas);
}
