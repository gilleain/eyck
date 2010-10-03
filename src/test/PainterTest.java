package test;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.vecmath.Point2d;

import org.junit.Test;

import painter.IPainter;

public class PainterTest {
    
    public static final int IMG_WIDTH = 200;
    
    public static final int IMG_HEIGHT = 200;
    
    public Image getBlankTestImage() {
        return new BufferedImage(
                IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
    }
    
    public List<Point2d> getRandomPoints(int w, int h, int count) {
        List<Point2d> pointList = new ArrayList<Point2d>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            double x = random.nextDouble() * w;
            double y = random.nextDouble() * h;
            pointList.add(new Point2d(x, y));
        }
        return pointList;
    }
    
    public void writeImage(Image image, File outputFile) {
        try {
            ImageIO.write((RenderedImage) image, "PNG", outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void test() {
        Image image = getBlankTestImage();
        final Graphics2D graphics = (Graphics2D) image.getGraphics();
        final int point_size = 4;
        
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
        
        List<Point2d> pointList = getRandomPoints(IMG_WIDTH, IMG_HEIGHT, 10);
        pointPainter.paint(pointList);
        writeImage(image, new File("test.png"));
    }

}
