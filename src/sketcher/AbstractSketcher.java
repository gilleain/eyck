package sketcher;

import java.awt.geom.Rectangle2D;

import core.AbstractArtist;

public abstract class AbstractSketcher<T,S> 
                extends AbstractArtist implements Sketcher<T, S> {

    public abstract Rectangle2D getModelBounds(T model);
    
    public double getScale(T model, Rectangle2D canvas) {
        return getScale(getModelBounds(model), canvas);
    }
    
}
