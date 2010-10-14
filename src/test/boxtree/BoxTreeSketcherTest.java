package test.boxtree;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import org.junit.Test;

import diagram.DiagramTree;
import diagram.IDiagram;

import test.BasePaintingTest;
import test.boxtree.diagram.BoxElement;
import test.boxtree.model.Box;
import test.boxtree.model.BoxTree;
import test.boxtree.render.BoxTreeSketcher;

public class BoxTreeSketcherTest extends BasePaintingTest {
    
    public final double BOX_MODEL_WIDTH = 10;
    
    public final double BOX_MODEL_HEIGHT = 10;
    
    public BoxTree makeTwoLevelModel() {
        BoxTree tree = new BoxTree();
        
        BoxTree childA = new BoxTree();
        childA.leaf = new Box(
                new Rectangle2D.Double(10, 100, BOX_MODEL_WIDTH, BOX_MODEL_HEIGHT));
        tree.children.add(childA);
        
        BoxTree childB = new BoxTree();
        childB.leaf = new Box(
                new Rectangle2D.Double(180, 100, BOX_MODEL_WIDTH, BOX_MODEL_HEIGHT));
        tree.children.add(childB);
        
        return tree;
    }
    
    public void draw(DiagramTree<BoxElement> tree, Graphics2D g) {
        for (IDiagram<BoxElement> diagram : tree.getDiagrams()) {
            for (BoxElement element : diagram.getElements()) {
                g.draw(element.bounds);
            }
        }
        
        for (DiagramTree<BoxElement> child : tree.getChildren()) {
            draw(child, g);
        }
    }
    
    @Test
    public void basicUsage() {
        BoxTree model = makeTwoLevelModel();
        BoxTreeSketcher sketcher = new BoxTreeSketcher();
        
        Image image = getBlankTestImage();
        Graphics2D g = (Graphics2D) image.getGraphics();
        DiagramTree<BoxElement> diagram = sketcher.sketch(model, getCanvas());
        draw(diagram, g);
        writeImage(image, "boxtree");
    }

}
