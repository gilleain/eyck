package layout;

import java.awt.geom.Rectangle2D;
import java.util.List;

public interface ILayout {
    
    public List<Rectangle2D> layout(Rectangle2D canvas);

}
