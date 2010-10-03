package painter;

import java.awt.geom.Rectangle2D;

public abstract class AbstractPainter<T> implements IPainter<T> {
    
    public abstract Rectangle2D getModelBounds(T model);
    
    public double getScale(T model, Rectangle2D canvas) {
        Rectangle2D modelBounds = getModelBounds(model);
        double bW = modelBounds.getWidth();
        double bH = modelBounds.getHeight();
        double cW = canvas.getWidth();
        double cH = canvas.getHeight();
        
        return Math.min(cW / bW, cH / bH);
    }

}
