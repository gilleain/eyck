package painter;

import java.awt.Graphics2D;

public interface AWTPainter<T> {
    
    public void paint(T object, Graphics2D g);

}
