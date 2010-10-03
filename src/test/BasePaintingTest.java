package test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.vecmath.Point2d;

public class BasePaintingTest {
    
  public static final int IMG_WIDTH = 200;
    
    public static final int IMG_HEIGHT = 200;
    
    public Image getBlankTestImage() {
        return new BufferedImage(
                IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
    }
    
    public List<Point2d> getRandomPointsInScreenSpace(int w, int h, int count) {
        List<Point2d> pointList = new ArrayList<Point2d>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            double x = random.nextDouble() * w;
            double y = random.nextDouble() * h;
            pointList.add(new Point2d(x, y));
        }
        return pointList;
    }
    
    public List<Point2d> getRandomPointsInModelSpace(int count) {
        List<Point2d> pointList = new ArrayList<Point2d>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
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

}
