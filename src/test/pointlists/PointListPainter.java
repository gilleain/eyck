package test.pointlists;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

import painter.AbstractPainter;
import painter.IBounder;

public class PointListPainter extends AbstractPainter<List<Point2d>> {

    private IBounder<List<Point2d>> bounder = new IBounder<List<Point2d>>() {

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

    @Override
    public void paint(List<Point2d> points, Rectangle2D canvas) {
        double scale = getScale(points, canvas);
        for (Point2d point : points) {
            int x = (int) (scale * point.x) - d;
            int y = (int) (scale * point.y) - d;
            graphics.fillOval(x, y, pointSize, pointSize);
        }
    }

    @Override
    public Rectangle2D getDiagramBounds(List<Point2d> model) {
        return bounder.getBounds(model);
    }

    @Override
    public void paint(List<Point2d> object, Point2d center) {
        // TODO Auto-generated method stub
        
    }

}
