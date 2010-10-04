package test.text;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Point2d;

import org.junit.Test;

import diagram.Diagram;

import test.text.impl.TextBox;
import test.text.impl.TextBoxElement;
import test.text.impl.TextBoxListDiagramBounder;
import test.text.impl.TextBoxListSketcher;

public class TextBoxListSketcherTest extends BaseTextBoxListTest {
    
    public void paint(Diagram<TextBoxElement> diagram, Image image) {
        Graphics2D g = (Graphics2D)image.getGraphics();
        g.setFont(LARGE_FONT);
        TextBoxListDiagramBounder bounder = new TextBoxListDiagramBounder(g);
        bounder.getBounds(diagram);
        for (TextBoxElement tbe : diagram.getElements()) {
            Rectangle2D bounds = tbe.bounds;
            g.draw(bounds);
        }
    }
    
    public void sketchModel(List<TextBox> model, String filename) {
        Image image = getBlankTestImage();
        TextBoxListSketcher sketcher = new TextBoxListSketcher();
        Diagram<TextBoxElement> diagram = sketcher.sketch(model, getCanvas());
        paint(diagram, image);
        writeImage(image, filename);
    }
    
    @Test
    public void basicUsage() {
        List<Point2d> points = getRandomPointsInModelSpace(5);
        List<TextBox> model = new ArrayList<TextBox>();
        for (int i = 0; i < points.size(); i++) {
            Point2d p = points.get(i);
            String letter = alphabet.substring(i, i + 1);
            model.add(new TextBox(letter, p));
        }
        
        sketchModel(model, "alphabet_sketch");
    }
    
    @Test
    public void singleLetter() {
        List<TextBox> model = new ArrayList<TextBox>();
        model.add(new TextBox("H", new Point2d(0, 0)));
        
        // TODO - IMPORTANT! MAKE SURE SCALE != INF
    }
    
    @Test
    public void letterPair() {
        sketchModel(makeLetterPairModel(), "letterPair_sketch");
    }

}
