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
    
    public BoxTree makeThreeLevelModel() {
        BoxTree tree = new BoxTree();
        
        BoxTree subTreeA = new BoxTree();
        BoxTree childAA = new BoxTree();
        childAA.leaf = new Box(new Rectangle2D.Double(10, 10, BOX_MODEL_WIDTH, BOX_MODEL_HEIGHT));
        subTreeA.children.add(childAA);
        BoxTree childAB = new BoxTree();
        childAB.leaf = new Box(new Rectangle2D.Double(110, 10, BOX_MODEL_WIDTH, BOX_MODEL_HEIGHT));
        subTreeA.children.add(childAB);
        tree.children.add(subTreeA);

        BoxTree subTreeB = new BoxTree();
        BoxTree childBA = new BoxTree();
        childBA.leaf = new Box(new Rectangle2D.Double(10, 110, BOX_MODEL_WIDTH, BOX_MODEL_HEIGHT));
        subTreeB.children.add(childBA);
        BoxTree childBB = new BoxTree();
        childBB.leaf = new Box(new Rectangle2D.Double(110, 110, BOX_MODEL_WIDTH, BOX_MODEL_HEIGHT));
        subTreeB.children.add(childBB);
        tree.children.add(subTreeB);
        
        return tree;
    }
    
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
    
    public void testModel(BoxTree model, String name) {
        BoxTreeSketcher sketcher = new BoxTreeSketcher();
        
        Image image = getBlankTestImage();
        Graphics2D g = (Graphics2D) image.getGraphics();
        DiagramTree<BoxElement> diagram = sketcher.sketch(model);
        draw(diagram, g);
        writeImage(image, name);
    }
    
    @Test
    public void twoLevelModelTest() {
        testModel(makeTwoLevelModel(), "boxtree2level");
    }
    
    @Test
    public void threeLevelModelTest() {
        testModel(makeThreeLevelModel(), "boxtree3level");
    }

}
