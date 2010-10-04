package painter;

import java.awt.geom.Rectangle2D;

import core.AbstractArtist;

public abstract class AbstractPainter<T> extends AbstractArtist implements IPainter<T> {
    
    public abstract Rectangle2D getModelBounds(T model);
    
    public double getScale(T model, Rectangle2D canvas) {
        return getScale(getModelBounds(model), canvas);
    }

}
