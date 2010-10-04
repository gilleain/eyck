package painter;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import core.AbstractArtist;

public abstract class AbstractPainter<T> extends AbstractArtist implements IPainter<T> {
    
    public abstract Rectangle2D getDiagramBounds(T diagram);
    
    public Point2d getCenter(T diagram) {
        Rectangle2D bounds = getDiagramBounds(diagram);
        return new Point2d(bounds.getCenterX(), bounds.getCenterY());
    }
    
    public double getScale(T diagram, Rectangle2D canvas) {
        return getScale(getDiagramBounds(diagram), canvas);
    }

}
