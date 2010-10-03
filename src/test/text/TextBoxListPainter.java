package test.text;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

import painter.AbstractPainter;
import painter.IBounder;

public class TextBoxListPainter extends AbstractPainter<List<TextBox>> {
    
    private IBounder<List<TextBox>> modelBounder = new TextBoxBounder();
    
    private IBounder<TextBoxListDiagram> diagramBounder;
    
    private Graphics2D graphics;
    
    public TextBoxListPainter(Graphics graphics) {
        this((Graphics2D) graphics);
    }
    
    public TextBoxListPainter(Graphics2D graphics) {
        this.graphics = graphics;
        diagramBounder = new TextBoxListDiagramBounder(graphics);
    }
    
    private Point getTextPoint(TextBoxDiagramElement textBox, double cX, double cY) {
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
    public void paint(List<TextBox> textBoxes, Rectangle2D canvas) {
        double scale = super.getScale(textBoxes, canvas);
        System.out.println("rough scale = " + scale);
        TextBoxListDiagram roughDiagram = new TextBoxListDiagram();
        for (TextBox textBox : textBoxes) {
            double x = textBox.center.x * scale;
            double y = textBox.center.y * scale;
            TextBoxDiagramElement element = 
                new TextBoxDiagramElement(textBox, new Point2d(x, y));
            roughDiagram.add(element);
        }
        Rectangle2D diagramBounds = diagramBounder.getBounds(roughDiagram);
        scale *= getScale(diagramBounds, canvas);
        System.out.println("exact scale = " + scale);
        for (TextBoxDiagramElement textBoxElement : roughDiagram) {
            double centerX = textBoxElement.textBox.center.x * scale;
            double centerY = textBoxElement.textBox.center.y * scale;
            Point p = getTextPoint(textBoxElement, centerX, centerY);
            graphics.drawString(textBoxElement.textBox.text, p.x, p.y);
        }
    }

    @Override
    public Rectangle2D getModelBounds(List<TextBox> model) {
        return modelBounder.getBounds(model);
    }

}
