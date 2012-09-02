package diagram;

import java.awt.geom.Point2D;

import diagram.element.CircleElement;
import diagram.element.ElementList;
import diagram.element.IDiagramElement;

public class DiagramTransformer {
	
	public static void center(
			IDiagramElement root, Point2D diagramCenter, Point2D canvasCenter) {
		double dx = canvasCenter.getX() - diagramCenter.getX();
		double dy = canvasCenter.getY() - diagramCenter.getY();
		translate(root, dx, dy);
	}
	
	public static void translate(IDiagramElement element, double dx, double dy) {
		if (element instanceof ElementList) {
			ElementList list = (ElementList) element;
			for (IDiagramElement child : list) {
				translate(child, dx, dy);
			}
		} else if (element instanceof CircleElement) {
			CircleElement c = (CircleElement) element; 
			c.center.set(c.center.x + dx, c.center.y + dy);
		} else {
			// TODO :)
		}
	}

}
