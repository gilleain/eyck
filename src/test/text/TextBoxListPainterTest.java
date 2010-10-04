package test.text;

import java.awt.Image;
import java.util.List;

import javax.vecmath.Point2d;

import org.junit.Test;

import diagram.Diagram;

import test.BasePaintingTest;
import test.text.impl.TextBox;
import test.text.impl.TextBoxElement;
import test.text.impl.TextBoxListDiagram;
import test.text.impl.TextBoxListPainter;

public class TextBoxListPainterTest extends BasePaintingTest {
    
    // would be nice to have alpha = [chr(i) for i in range(ord('A'), ord('Z')]
    public final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    @Test
    public void basicUsage() {
        // make the model
        List<Point2d> points = getRandomPointsInModelSpace(5);
        Diagram<TextBoxElement> textBoxes = new TextBoxListDiagram();
        for (int i = 0; i < points.size(); i++) {
            TextBox textBox = new TextBox(alphabet.substring(i, i+1), null);
            textBoxes.add(new TextBoxElement(textBox, points.get(i)));
        }
        
        // render it
        Image image = getBlankTestImage();
        TextBoxListPainter painter = new TextBoxListPainter(image.getGraphics());
        painter.paint(textBoxes, getCanvas(), 1.0);
        writeImage(image, "alphabet");
    }

}
