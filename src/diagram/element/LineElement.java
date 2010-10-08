package diagram.element;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

public class LineElement extends LeafElement {
    
    public Point2d a;
    
    public Point2d b;
    
    public LineElement(Point2d a, Point2d b) {
        this(a, b, Color.BLACK);
    }
    
    public LineElement(Point2d a, Point2d b, Color c) {
        super(calculateCenter(a, b));
        this.a = a;
        this.b = b;
        color = c;
    }

    @Override
    public Rectangle2D getBounds() {
        double x, y, w, h;
        if (a.x < b.x) {
            x = a.x;
            w = b.x - a.x;
        } else {
            x = b.x;
            w = a.x - b.x;
        }
        if (a.y < b.y) {
            y = a.y;
            h = b.y - a.y;
        } else {
            y = b.y;
            h = a.y - b.y;
        }
        return new Rectangle2D.Double(x, y, w, h);
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
