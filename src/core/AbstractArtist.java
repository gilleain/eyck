package core;

import java.awt.geom.Rectangle2D;

public class AbstractArtist {
    
    public double getScale(Rectangle2D drawing, Rectangle2D canvas) {
        double bW = drawing.getWidth();
        double bH = drawing.getHeight();
        double cW = canvas.getWidth();
        double cH = canvas.getHeight();
        
        return Math.min(cW / bW, cH / bH);
    }

}
