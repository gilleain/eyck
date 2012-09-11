package divide;

import java.awt.geom.Rectangle2D;
import java.util.List;

public interface IrregularDivider extends IDivider {
	
	public List<Rectangle2D> divide(Rectangle2D canvas);

}
