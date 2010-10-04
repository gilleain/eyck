package test.text.impl;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

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

    @Override
    public void paint(Diagram<TextBoxElement> textBoxDiagram, Rectangle2D canvas, double scale) {
        
        scale *= getScale(textBoxDiagram, canvas);
        System.out.println("exact scale = " + scale);
        
        for (TextBoxElement textBoxElement : textBoxDiagram.getElements()) {
            double centerX = textBoxElement.textBox.center.x * scale;
            double centerY = textBoxElement.textBox.center.y * scale;
            Point p = getTextPoint(textBoxElement, centerX, centerY);
            graphics.drawString(textBoxElement.textBox.text, p.x, p.y);
        }
    }

    @Override
    public Rectangle2D getDiagramBounds(Diagram<TextBoxElement> model) {
        return diagramBounder.getBounds(model);
    }

}
