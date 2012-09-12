package awt;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import painter.AbstractPainter;
import diagram.DiagramBounder;
import diagram.element.CircleElement;
import diagram.element.ElementList;
import diagram.element.IDiagramElement;
import diagram.element.LineElement;
import diagram.element.TextElement;

/**
 * Paints a single diagram (tree of diagram elements), using java's awt Graphics class.
 * 
 * @author maclean
 *
 */
public class BasicAWTPainter extends AbstractPainter<IDiagramElement> {

	private Graphics2D g;

	private DiagramBounder bounder;
	
	private boolean shouldTransform;
	
	public BasicAWTPainter(Graphics g) {
		this(g, true);
	}
	
	public BasicAWTPainter(Graphics g, boolean shouldTransform) {
		this.g = (Graphics2D) g;
		this.bounder = new DiagramBounder(g);
		this.shouldTransform = shouldTransform;
	}

	@Override
	public Rectangle2D getDiagramBounds(IDiagramElement diagram) {
		return bounder.getBounds(diagram);
	}

	@Override
	public void paint(IDiagramElement diagram, Rectangle2D canvas) {
		double scale = getScale(diagram, canvas);
		Point2d canvasCenter = getCenter(canvas);
		paint(diagram, canvasCenter, scale);
	}

	@Override
	public void paint(IDiagramElement diagram, Point2d center) {
		double scale = 1.0;
		paint(diagram, center, scale);
	}

	private void paint(IDiagramElement diagram, Point2d canvasCenter, double scale) {
		Point2d diagramCenter = getCenter(diagram);
		System.out.println("painting at canvas center " 
							+ canvasCenter +
							" diagram center " + diagramCenter
							+ " scale " + scale );

		AffineTransform savedTransform = null;
		if (shouldTransform) {
			// set the transform
			savedTransform = g.getTransform();
			g.translate(canvasCenter.x, canvasCenter.y);
			g.scale(scale, scale);
			g.translate(-diagramCenter.x, -diagramCenter.y);
		}

		// XXX - why are we passing the canvas center?
		paintRecursively(diagram, diagramCenter, scale, canvasCenter);

		// restore the transform
		if (shouldTransform) {
			g.setTransform(savedTransform);
		}
	}

	private void paintRecursively(IDiagramElement diagram, Point2d diagramCenter, double scale, Point2d canvasCenter) {
		for (IDiagramElement element : diagram.getChildren()) {
			Point2d elementCenter = element.getCenter();
			if (element instanceof TextElement) {
				handleTextElement((TextElement) element, elementCenter);
			} else if (element instanceof LineElement) {
				handleLineElement((LineElement) element, diagramCenter, scale, canvasCenter);
			} else if (element instanceof ElementList) {
				paintRecursively(element, diagramCenter, scale, canvasCenter);
			} else if (element instanceof CircleElement) {
				handleCircleElement((CircleElement)element, elementCenter);
			}
		}
	}
	
	private void handleCircleElement(CircleElement element, Point2d p) {
		g.setColor(element.getColor());
		double r = element.getRadius();
		g.drawOval((int)(p.x - r), (int)(p.y - r), (int)(r * 2), (int)(r * 2));
	}

	private void handleTextElement(TextElement element, Point2d center) {
		Point p = getTextPoint(element, center.x, center.y);
		g.setColor(Color.WHITE);
		int w = (int)element.bounds.getWidth();
		int h = (int)element.bounds.getHeight();
		int x = (int)center.x - (w/2);
		int y = (int)center.y - (h/2);
		g.fillRect(x, y, w, h);
		g.setColor(element.getColor());
		g.drawString(element.text, (int)p.x, (int)p.y);
	}

	private void handleLineElement(
			LineElement element, Point2d diagramCenter, double scale, Point2d canvasCenter) {
		g.setColor(element.getColor());
		Point2d a = element.a;
		Point2d b = element.b;
		g.drawLine((int)a.x, (int)a.y, (int)b.x, (int)b.y);
	}

	private Point getTextPoint(TextElement text, double cX, double cY) {
		FontMetrics metrics = g.getFontMetrics();
		Rectangle2D stringBounds = metrics.getStringBounds(text.text, g);
		text.bounds = stringBounds;
		double halfWidth = stringBounds.getWidth() / 2;
		double halfHeight = stringBounds.getHeight() / 2;
		double ascent = metrics.getAscent();
		int x = (int) (cX - halfWidth);
		int y = (int) (cY - halfHeight + ascent);
		return new Point(x, y);
	}

}
