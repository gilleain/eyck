package test;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

import org.junit.Test;

public class PointListPainterTest extends BasePaintingTest {
    
    @Test
    public void basicUse() {
        Image image = getBlankTestImage();
        PointListPainter painter = new PointListPainter(image.getGraphics());
        List<Point2d> model = getRandomPointsInModelSpace(10);
        Rectangle2D canvas = getCanvas();
        painter.paint(model, canvas);
        writeImage(image, "plp_model");
    }

}
