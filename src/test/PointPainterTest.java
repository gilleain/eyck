package test;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.vecmath.Point2d;

import org.junit.Test;

import painter.IPainter;

public class PointPainterTest extends BasePaintingTest {
    
    public final int point_size = 4;
    
    @Test
    public void testDrawingPointsInScreenSpace() {
        Image image = getBlankTestImage();
        final Graphics2D graphics = (Graphics2D) image.getGraphics();
        
        IPainter<List<Point2d>> pointPainter = new IPainter<List<Point2d>>() {

            @Override
            public void paint(List<Point2d> points) {
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
        pointPainter.paint(pointList);
        writeImage(image, new File("test.png"));
    }
    
    @Test
    public void testDrawingPointsInModelSpace() {
        
    }

}
