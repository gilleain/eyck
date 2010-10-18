package painter;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import layout.ILayout;


import diagram.DiagramTree;
import divide.IDivider;

public interface ICompositePainter<T> {
    
    /**
     * Paint the composite diagram to fit entirely within the boundary of the
     * supplied canvas, using the divider to make sub-canvases.
     * 
     * @param compositeDiagram
     * @param canvas
     * @param divider
     */
    public void paint(DiagramTree<T> compositeDiagram, Rectangle2D canvas, IDivider divider);

    /**
     * Paint the composite diagram centered on the supplied point, using the 
     * layout to position the diagram's parts.
     *  
     * @param compositeDiagram
     * @param center
     * @param layout
     */
    public void paint(DiagramTree<T> compositeDiagram, Point2d center, ILayout<T> layout);
}
