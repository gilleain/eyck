package test.boxtree;

import java.awt.Graphics2D;
import java.awt.Image;

import org.junit.Test;

import diagram.Diagram;

import test.BasePaintingTest;
import test.boxtree.diagram.BoxElement;
import test.boxtree.model.BoxTree;
import test.boxtree.render.BoxTreeSketcher;

public class BoxTreeSketcherTest extends BasePaintingTest {
    
    public BoxTree makeModel() {
        BoxTree tree = new BoxTree();
        BoxTree childA = new BoxTree();
        tree.children.add(childA);
        BoxTree childB = new BoxTree();
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
    }

}
