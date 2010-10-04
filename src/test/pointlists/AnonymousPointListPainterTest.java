package test.pointlists;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

import org.junit.Test;

import painter.IBounder;
import painter.IPainter;
import test.BasePaintingTest;

public class AnonymousPointListPainterTest extends BasePaintingTest {
    
    public final int point_size = 4;
    
    @Test
    public void testDrawingPointsInScreenSpace() {
        Image image = getBlankTestImage();
        final Graphics2D graphics = (Graphics2D) image.getGraphics();
        
        IPainter<List<Point2d>> pointPainter = new IPainter<List<Point2d>>() {

            @Override
            public void paint(List<Point2d> points, Rectangle2D canvas) {
                int d = point_size/2;
                for (Point2d point : points) {
                    int x = (int)point.x - d;
                    int y = (int)point.y - d;
                    graphics.fillOval(x, y, 2 * d, 2 * d);
                }
            }
        };
        
        List<Point2d> pointList = 
            getRandomPointsInScreenSpace(IMG_WIDTH, IMG_HEIGHT, 10);
        
        // empty canvas?
        pointPainter.paint(pointList, new Rectangle2D.Double());
        writeImage(image, "screen_points");
    }
    
    @Test
    public void testDrawingPointsInModelSpace() {
        Image image = getBlankTestImage();
        final Graphics2D graphics = (Graphics2D) image.getGraphics();
        IBounder<List<Point2d>> boundsCalculator = 
            new IBounder<List<Point2d>>() {

            @Override
            public Rectangle2D getBounds(List<Point2d> points) {
                Rectangle2D bounds = new Rectangle2D.Double();
                for (Point2d point : points) {
                    bounds.add(point.x, point.y);
                }
                return bounds;
            }
        };
        
        List<Point2d> pointList = getRandomPointsInModelSpace(10);
        final Rectangle2D bounds = boundsCalculator.getBounds(pointList);
        IPainter<List<Point2d>> pointPainter = new IPainter<List<Point2d>>() {

            @Override
            public void paint(List<Point2d> points, Rectangle2D canvas) {
                double bW = bounds.getWidth();
                double bH = bounds.getHeight();
                double cW = canvas.getWidth();
                double cH = canvas.getHeight();
                
                double scale = Math.min(cW / bW, cH / bH);
                
                int d = point_size / 2;
                for (Point2d point : points) {
                    int x = (int)(point.x * scale) - d;
                    int y = (int)(point.y * scale) - d;
                    graphics.fillOval(x, y, 2 * d, 2 * d);
                }
            }
        };
        Rectangle2D canvas = new Rectangle2D.Double(0, 0, IMG_WIDTH, IMG_HEIGHT);
        pointPainter.paint(pointList, canvas);
        writeImage(image, "model_points");
    }

}
