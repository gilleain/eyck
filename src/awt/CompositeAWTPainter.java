package awt;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

import layout.ILayout;
import painter.ICompositePainter;
import diagram.DiagramBounder;
import diagram.element.IDiagramElement;
import divide.IDivider;

/**
 * Uses a BasicAWTPainter to paint a set of diagrams.
 * 
 * @author maclean
 *
 */
public class CompositeAWTPainter implements ICompositePainter<IDiagramElement> {
    
    private BasicAWTPainter subPainter;
    
    private DiagramBounder bounder;
    
    public CompositeAWTPainter(Graphics g) {
        subPainter = new BasicAWTPainter(g);
        bounder = new DiagramBounder(g);
    }

    @Override
    public void paint(IDiagramElement compositeDiagram,
                      Rectangle2D canvas, 
                      IDivider divider) {
    	List<IDiagramElement> children = compositeDiagram.getChildren();
        List<Rectangle2D> canvases = divider.divide(canvas, children.size());
        int i = 0;
        for (IDiagramElement diagram : children) {
            subPainter.paint(diagram, canvases.get(i));
            i++;
        }
    }

    @Override
    public void paint(IDiagramElement compositeDiagram,
                      Point2d center, 
                      ILayout layout) {
        List<Point2d> centers = layout.layout(compositeDiagram, center, bounder);
        System.out.println("next level of centers : " + centers);
        int i = 0;
        for (IDiagramElement diagram : compositeDiagram.getChildren()) {
            subPainter.paint(diagram, centers.get(i));
            i++;
        }
    }

}
