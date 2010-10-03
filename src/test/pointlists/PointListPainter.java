package test.pointlists;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

import painter.BoundsCalculator;
import painter.IPainter;

public class PointListPainter implements IPainter<List<Point2d>> {
    
    private BoundsCalculator<List<Point2d>> boundsCalculator =
        new BoundsCalculator<List<Point2d>>() {

            @Override
            public Rectangle2D getBounds(List<Point2d> points) {
                Rectangle2D bounds = new Rectangle2D.Double();
                for (Point2d point : points) {
                    bounds.add(point.x, point.y);
                }
                return bounds;
            }
    };
    
    private final int pointSize = 4;
    
    private final int d = pointSize / 2;
    
    private Graphics2D graphics;
    
    public PointListPainter(Graphics g) {
        this((Graphics2D) g);
    }
    
    public PointListPainter(Graphics2D graphics) {
        this.graphics = graphics;
    }
    
    private double calculateScale(List<Point2d> points, Rectangle2D canvas) {
        Rectangle2D bounds = boundsCalculator.getBounds(points);
        double bW = bounds.getWidth();
        double bH = bounds.getHeight();
        double cW = canvas.getWidth();
        double cH = canvas.getHeight();
        
        return Math.min(cW / bW, cH / bH);
    }

    @Override
    public void paint(List<Point2d> points, Rectangle2D canvas) {
        double scale = calculateScale(points, canvas);
        for (Point2d point : points) {
            int x = (int) (scale * point.x) - d;
            int y = (int) (scale * point.y) - d;
            graphics.fillOval(x, y, pointSize, pointSize);
        }
    }

}
