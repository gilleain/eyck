package test.text.render;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import diagram.IDiagram;
import diagram.TextElement;

import painter.AbstractPainter;
import painter.IBounder;
import test.text.diagram.TextListDiagramBounder;

public class TextBoxListPainter extends AbstractPainter<IDiagram<TextElement>> {
    
    private IBounder<IDiagram<TextElement>> diagramBounder;
    
    private Graphics2D graphics;
    
    public TextBoxListPainter(Graphics graphics) {
        this((Graphics2D) graphics);
    }
    
    public TextBoxListPainter(Graphics2D graphics) {
        this.graphics = graphics;
        diagramBounder = new TextListDiagramBounder(graphics);
    }
    
    private Point getTextPoint(TextElement textBox, double cX, double cY) {
        FontMetrics metrics = graphics.getFontMetrics();
        Rectangle2D stringBounds;
        if (textBox.bounds == null) {
            stringBounds = metrics.getStringBounds(textBox.text, graphics);
        } else {
            stringBounds = textBox.bounds;
        }
        double halfWidth = stringBounds.getWidth() / 2;
        double halfHeight = stringBounds.getHeight() / 2;
        double ascent = metrics.getAscent();
        int x = (int) (cX - halfWidth);
        int y = (int) (cY - halfHeight + ascent);
        return new Point(x, y);
    }
    
    @Override
    public void paint(IDiagram<TextElement> textBoxDiagram, Rectangle2D canvas) {
        
        double scale = getScale(textBoxDiagram, canvas);
        Point2d center = getCenter(textBoxDiagram);
        Point2d cc = new Point2d(canvas.getCenterX(), canvas.getCenterY());
        System.out.println("exact scale = " + scale);
        
        for (TextElement textBoxElement : textBoxDiagram.getElements()) {
            double oldX = textBoxElement.center.x;
            double oldY = textBoxElement.center.y;
            double newX = transform(oldX, center.x, scale, cc.x);
            double newY = transform(oldY, center.y, scale, cc.y);
            Point p = getTextPoint(textBoxElement, newX, newY);
            System.out.println("drawing string at " + p);
            graphics.drawString(textBoxElement.text, p.x, p.y);
        }
    }

    @Override
    public Rectangle2D getDiagramBounds(IDiagram<TextElement> model) {
        return diagramBounder.getBounds(model);
    }

}
