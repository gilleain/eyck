package sketcher;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import core.AbstractArtist;

public abstract class AbstractSketcher<T,S> 
                extends AbstractArtist implements Sketcher<T, S> {

    public abstract Rectangle2D getModelBounds(T model);
    
    public Point2d getCenter(T model) {
        Rectangle2D bounds = getModelBounds(model);
        return new Point2d(bounds.getCenterX(), bounds.getCenterY());
    }
    
    public double getScale(T model, Rectangle2D canvas) {
        return getScale(getModelBounds(model), canvas);
    }
    
}
