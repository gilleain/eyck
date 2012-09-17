package diagram.element;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

public class CircleElement extends LeafElement {
	
	private double radius;

	public CircleElement(Point2d center, double radius) {
		super(center);
		this.radius = radius;
		this.outlineColor = Color.BLACK;
	}
	
	public Rectangle2D getBounds() {
		double x = getCenter().x - radius;
		double y = getCenter().y - radius;
		return new Rectangle2D.Double(x, y, radius * 2, radius * 2);
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}

}
