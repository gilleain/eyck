package diagram.element;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

public class LineElement extends LeafElement {
    
    private Point2d a;
    
    private Point2d b;
    
    public LineElement(Point2d a, Point2d b) {
        super(calculateCenter(a, b));
        this.a = a;
        this.b = b;
    }

    @Override
    public Rectangle2D getBounds() {
        // XXX TODO!
        double w = a.x - b.x;
        double h = a.y - b.y;
        return new Rectangle2D.Double(a.x, b.x, w, h);
    }
    
    private static Point2d calculateCenter(Point2d a, Point2d b) {
        Point2d c = new Point2d(a);
        c.interpolate(b, 0.5);
        return c;
    }

}
