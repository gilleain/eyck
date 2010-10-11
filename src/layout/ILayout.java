package layout;

import java.awt.geom.Rectangle2D;

public interface ILayout<T> {
    
    public void layout(T object, Rectangle2D canvas);

}
