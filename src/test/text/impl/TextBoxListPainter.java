package test.text.impl;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import diagram.Diagram;

import painter.AbstractPainter;
import painter.IBounder;

public class TextBoxListPainter extends AbstractPainter<Diagram<TextBoxElement>> {
    
    private IBounder<Diagram<TextBoxElement>> diagramBounder;
    
    private Graphics2D graphics;
    
    public TextBoxListPainter(Graphics graphics) {
        this((Graphics2D) graphics);
    }
    
    public TextBoxListPainter(Graphics2D graphics) {
        this.graphics = graphics;
        diagramBounder = new TextBoxListDiagramBounder(graphics);
    }
    
    private Point getTextPoint(TextBoxElement textBox, double cX, double cY) {
        FontMetrics metrics = graphics.getFontMetrics();
        Rectangle2D stringBounds;
        if (textBox.bounds == null) {
            stringBounds = metrics.getStringBounds(textBox.textBox.text, graphics);
        } else {
            stringBounds = textBox.bounds;
        }
        double halfWidth = stringBounds.getWidth() / 2;
        double height = stringBounds.getHeight();
        double ascent = metrics.getAscent();
        int x = (int) (cX - halfWidth);
        int y = (int) (cY - height + ascent);
        return new Point(x, y);
    }
    
    public double transform(
            double coord, double diagramCenter, double scale, double screenCenter) {
        double t = ((coord - diagramCenter) * scale) + screenCenter;
        System.out.println(
                String.format(
                        "transforming ((%2.2f - %2.2f) * %2.2f) + %2.2f -> %2.2f",
                        coord, diagramCenter, scale, screenCenter, t));
        return t;
    }

    @Override
    public void paint(Diagram<TextBoxElement> textBoxDiagram, Rectangle2D canvas) {
        
        double scale = getScale(textBoxDiagram, canvas);
        Point2d center = getCenter(textBoxDiagram);
        Point2d cc = new Point2d(canvas.getCenterX(), canvas.getCenterY());
        System.out.println("exact scale = " + scale);
        
        for (TextBoxElement textBoxElement : textBoxDiagram.getElements()) {
            double oldX = textBoxElement.center.x;
            double oldY = textBoxElement.center.y;
            double newX = transform(oldX, center.x, scale, cc.x);
            double newY = transform(oldY, center.y, scale, cc.y);
            Point p = getTextPoint(textBoxElement, newX, newY);
            System.out.println("drawing string at " + p);
            graphics.drawString(textBoxElement.textBox.text, p.x, p.y);
        }
    }

    @Override
    public Rectangle2D getDiagramBounds(Diagram<TextBoxElement> model) {
        return diagramBounder.getBounds(model);
    }

}
