package painter;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import layout.ILayout;
import divide.IrregularDivider;
import divide.RegularDivider;

public interface ICompositePainter<T> {
    
    /**
     * Paint the composite diagram to fit entirely within the boundary of the
     * supplied canvas, using the divider to make sub-canvases.
     * 
     * @param compositeDiagram
     * @param canvas
     * @param divider
     */
    public void paint(T compositeDiagram, Rectangle2D canvas, RegularDivider divider);
    
    public void paint(T compositeDiagram, Rectangle2D canvas, IrregularDivider divider);

    /**
     * Paint the composite diagram centered on the supplied point, using the 
     * layout to position the diagram's parts.
     *  
     * @param compositeDiagram
     * @param center
     * @param layout
     */
    public void paint(T compositeDiagram, Point2d center, ILayout layout);
}
