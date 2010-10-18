package test.text;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Point2d;

import org.junit.Test;

import diagram.IDiagram;
import diagram.element.TextElement;

import test.text.diagram.TextListDiagramBounder;
import test.text.model.Text;
import test.text.render.TextBoxListSketcher;

public class TextListSketcherTest extends BaseTextListTest {
    
    public void paint(IDiagram<TextElement> diagram, Image image) {
        Graphics2D g = (Graphics2D)image.getGraphics();
        g.setFont(LARGE_FONT);
        TextListDiagramBounder bounder = new TextListDiagramBounder(g);
        bounder.getBounds(diagram);
        for (TextElement tbe : diagram.getElements()) {
            Rectangle2D bounds = tbe.bounds;
            g.draw(bounds);
        }
    }
    
    public void sketchModel(List<Text> model, String filename) {
        Image image = getBlankTestImage();
        TextBoxListSketcher sketcher = new TextBoxListSketcher();
        IDiagram<TextElement> diagram = sketcher.sketch(model);
        paint(diagram, image);
        writeImage(image, filename);
    }
    
    @Test
    public void basicUsage() {
        List<Point2d> points = getRandomPointsInModelSpace(5);
        List<Text> model = new ArrayList<Text>();
        for (int i = 0; i < points.size(); i++) {
            Point2d p = points.get(i);
            String letter = alphabet.substring(i, i + 1);
            model.add(new Text(letter, p));
        }
        
        sketchModel(model, "alphabet_sketch");
    }
    
    @Test
    public void singleLetter() {
        List<Text> model = new ArrayList<Text>();
        model.add(new Text("H", new Point2d(0, 0)));
        
        // TODO - IMPORTANT! MAKE SURE SCALE != INF
    }
    
    @Test
    public void letterPair() {
        sketchModel(makeLetterPairModel(), "letterPair_sketch");
    }

}
