package diagram.element;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

public class LineElement extends LeafElement {
    
    public Point2d a;
    
    public Point2d b;
    
    public LineElement(Point2d a, Point2d b) {
        super(calculateCenter(a, b));
        this.a = a;
        this.b = b;
    }

    @Override
    public Rectangle2D getBounds() {
        // XXX TODO!
        double w = Math.abs(a.x - b.x);
        double h = Math.abs(a.y - b.y);
        Rectangle2D r = new Rectangle2D.Double(a.x, b.x, w, h);
        System.out.println("r = " + r);
        return r;
    }
    
    private static Point2d calculateCenter(Point2d a, Point2d b) {
        Point2d c = new Point2d(a);
        c.interpolate(b, 0.5);
        System.out.println(
                String.format("center of (%2.2f, %2.2f) and (%2.2f, %2.2f) is (%2.2f, %2.2f) ",
                        a.x, a.y, b.x, b.y, c.x, c.y));
        return c;
    }

}
