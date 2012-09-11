package divide;

import java.awt.geom.Rectangle2D;
import java.util.List;

public interface RegularDivider extends IDivider {

	public List<Rectangle2D> divide(Rectangle2D canvas, int parts);
	
}
