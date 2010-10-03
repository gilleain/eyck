package painter;

import java.awt.geom.Rectangle2D;

public abstract class AbstractPainter<T> implements IPainter<T> {
    
    public abstract Rectangle2D getModelBounds(T model);
    
    public double getScale(T model, Rectangle2D canvas) {
        return getScale(getModelBounds(model), canvas);
    }
    
    public double getScale(Rectangle2D drawing, Rectangle2D canvas) {
        double bW = drawing.getWidth();
        double bH = drawing.getHeight();
        double cW = canvas.getWidth();
        double cH = canvas.getHeight();
        
        return Math.min(cW / bW, cH / bH);
    }

}
