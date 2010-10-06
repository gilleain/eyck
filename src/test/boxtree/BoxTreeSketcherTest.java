package test.boxtree;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import org.junit.Test;

import diagram.Diagram;

import test.BasePaintingTest;
import test.boxtree.diagram.BoxElement;
import test.boxtree.model.Box;
import test.boxtree.model.BoxTree;
import test.boxtree.render.BoxTreeSketcher;

public class BoxTreeSketcherTest extends BasePaintingTest {
    
    public final double BOX_MODEL_WIDTH = 4;
    
    public final double BOX_MODEL_HEIGHT = 4;
    
    public BoxTree makeModel() {
        BoxTree tree = new BoxTree();
        
        BoxTree childA = new BoxTree();
        childA.leaf = new Box(
                new Rectangle2D.Double(0, 0, BOX_MODEL_WIDTH, BOX_MODEL_HEIGHT));
        tree.children.add(childA);
        
        BoxTree childB = new BoxTree();
        childB.leaf = new Box(
                new Rectangle2D.Double(2, 0, BOX_MODEL_WIDTH, BOX_MODEL_HEIGHT));
        tree.children.add(childB);
        
        return tree;
    }
    
    @Test
    public void basicUsage() {
        BoxTree model = makeModel();
        BoxTreeSketcher sketcher = new BoxTreeSketcher();
        
        Image image = getBlankTestImage();
        Graphics2D g = (Graphics2D) image.getGraphics();
        Diagram<BoxElement> diagram = sketcher.sketch(model, getCanvas());
        for (BoxElement element : diagram.getElements()) {
            g.draw(element.bounds);
        }
        writeImage(image, "boxtree");
    }

}
