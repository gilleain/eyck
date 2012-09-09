package awt;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

import layout.ILayout;

import painter.ICompositePainter;
import diagram.DiagramBounder;
import diagram.element.ElementList;
import diagram.element.IDiagramElement;
import divide.IDivider;

public class ListAWTPainter implements ICompositePainter<List<IDiagramElement>> {
	  
    private BasicAWTPainter subPainter;
    
    private DiagramBounder bounder;
    
    public ListAWTPainter(Graphics g) {
        subPainter = new BasicAWTPainter(g);
        bounder = new DiagramBounder(g);
    }

	@Override
	public void paint(List<IDiagramElement> diagramList, Rectangle2D canvas, IDivider divider) {
		List<Rectangle2D> canvases = divider.divide(canvas, diagramList.size());
		int i = 0;
		for (IDiagramElement diagram : diagramList) {
			subPainter.paint(diagram, canvases.get(i));
			i++;
		}
		
	}

	@Override
	public void paint(List<IDiagramElement> diagramList, Point2d center, ILayout layout) {
		// XXX FIXME
		ElementList compositeDiagram = new ElementList();
		for (IDiagramElement diagram : diagramList) {
			compositeDiagram.add(diagram);
		}
		
		List<Point2d> centers = layout.layout(compositeDiagram, center, bounder);
        int i = 0;
        for (IDiagramElement diagram : diagramList) {
            subPainter.paint(diagram, centers.get(i));
            i++;
        }
		
	}

}
