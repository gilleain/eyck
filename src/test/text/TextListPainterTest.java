package test.text;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

import org.junit.Test;

import diagram.IDiagram;
import diagram.element.TextElement;

import test.text.diagram.TextListDiagram;
import test.text.model.Text;
import test.text.model.TextBounder;
import test.text.render.TextBoxListPainter;

public class TextListPainterTest extends BaseTextListTest {
    
    public IDiagram<TextElement> makeDiagram(List<Text> model) {
        TextBounder bounder = new TextBounder();
        Rectangle2D modelBounds = bounder.getBounds(model);
        Point2d mc = new Point2d(modelBounds.getCenterX(), modelBounds.getCenterY());
        Rectangle2D canvas = getCanvas();
        Point2d cc = new Point2d(canvas.getCenterX(), canvas.getCenterY());
        
        double scale = Math.min(canvas.getWidth() / modelBounds.getWidth(),
                                canvas.getHeight() / modelBounds.getHeight());
        
        IDiagram<TextElement> diagram = new TextListDiagram();
        for (Text textBox : model) {
            double x = ((textBox.center.x - mc.x) * scale) + cc.x;
            double y = ((textBox.center.y - mc.y) * scale) + cc.y;
            Point2d diagramPoint = new Point2d(x, y);
            diagram.add(new TextElement(textBox.text, diagramPoint));
        }
        return diagram;
    }
    
    @Test
    public void basicUsage() {
        // make the 'model', but in screen space
        List<Point2d> points = getRandomPointsInScreenSpace(IMG_WIDTH, IMG_HEIGHT, 5);
        IDiagram<TextElement> textBoxes = new TextListDiagram();
        for (int i = 0; i < points.size(); i++) {
            Point2d p = points.get(i);
            String letter = alphabet.substring(i, i + 1);
            Text textBox = new Text(letter, p);
            textBoxes.add(new TextElement(textBox.text, p));
        }
        
        // render it
        Image image = getBlankTestImage();
        TextBoxListPainter painter = new TextBoxListPainter(image.getGraphics());
        painter.paint(textBoxes, getCanvas());
        writeImage(image, "alphabet");
    }
    
    @Test
    public void letterPairTest() {
        List<Text> model = makeLetterPairModel();
        IDiagram<TextElement> diagram = makeDiagram(model);
        
        Image image = getBlankTestImage();
        Graphics g = image.getGraphics();
        g.setFont(LARGE_FONT);
        TextBoxListPainter painter = new TextBoxListPainter(g);
        painter.paint(diagram, getCanvas());
        writeImage(image, "letterPair_painted");
    }

}
