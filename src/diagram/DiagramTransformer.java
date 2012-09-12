package diagram;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

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
	
	public static void scaleToFit(IDiagramElement root, Rectangle2D canvas) {
		Rectangle2D bounds = root.getBounds();
		double dx = canvas.getWidth() / bounds.getWidth();
		double dy = canvas.getHeight() / bounds.getHeight();
		double scale = Math.min(dx, dy);
		double cx = canvas.getCenterX();
		double cy = canvas.getCenterY();
		double xx = bounds.getCenterX();
		double yy = bounds.getCenterY();
		scaleToFit(root, cx, cy, xx, yy, scale);
	}
	
	public static void scaleToFit(IDiagramElement element, double cx, double cy, double xx, double yy, double scale) {
		if (element instanceof ElementList) {
			ElementList list = (ElementList) element;
			for (IDiagramElement child : list) {
				scaleToFit(child, cx, cy, xx, yy, scale);
			}
		} else if (element instanceof CircleElement) {
			CircleElement c = (CircleElement) element;
			double x = ((c.center.x - xx) * scale) + cx;
			double y = ((c.center.y - yy) * scale) + cy;
			System.out.println("setting " + c.center + " to " + x + " " + y);
			c.center.set(x, y);
		} else {
			// TODO :)
		}
	}

}
