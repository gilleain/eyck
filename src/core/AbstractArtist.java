package core;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

public class AbstractArtist {
    
    public double getScale(Rectangle2D drawing, Rectangle2D canvas) {
        double bW = drawing.getWidth();
        double bH = drawing.getHeight();
        double cW = canvas.getWidth();
        double cH = canvas.getHeight();
        
        return Math.min(cW / bW, cH / bH);
    }
    
    public Point2d getCenter(Rectangle2D rectangle) {
        return new Point2d(rectangle.getCenterX(), rectangle.getCenterY());
    }
    
    public double transform(
            double coord, double diagramCenter, double scale, double screenCenter) {
        double t = ((coord - diagramCenter) * scale) + screenCenter;
        System.out.println(
                String.format(
                        "transforming ((%2.2f - %2.2f) * %2.2f) + %2.2f -> %2.2f",
                        coord, diagramCenter, scale, screenCenter, t));
        return t;
    }
    
    public Point2d transform(
            Point2d p, Point2d diagramCenter, double scale, Point2d screenCenter) {
        Point2d t = new Point2d(p);
        t.sub(diagramCenter);
        t.scale(scale);
        t.add(screenCenter);
        System.out.println(
                String.format(
                        "transforming (((%2.2f, %2.2f) - (%2.2f, %2.2f)) * %2.2f)" +
                        " + (%2.2f, %2.2f) -> (%2.2f, %2.2f)",
                        p.x, p.y, diagramCenter.x, diagramCenter.y, scale, 
                        screenCenter.x, screenCenter.y, t.x, t.y));
        return t;
    }

}
