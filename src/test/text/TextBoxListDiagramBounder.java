package test.text;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import painter.IBounder;

public class TextBoxListDiagramBounder implements
        IBounder<TextBoxListDiagram> {
    
    private Graphics2D graphics;
    
    public TextBoxListDiagramBounder(Graphics2D graphics) {
        this.graphics = graphics;
    }

    @Override
    public Rectangle2D getBounds(TextBoxListDiagram diagram) {
        Rectangle2D bounds = new Rectangle2D.Double();
        FontMetrics metrics = graphics.getFontMetrics();
        for (TextBoxDiagramElement textBoxElement : diagram) {
            String text = textBoxElement.textBox.text;
            Rectangle2D stringBounds = metrics.getStringBounds(text, graphics);
            double w2 = stringBounds.getWidth() / 2;
            double h2 = stringBounds.getHeight() / 2;
            Point2d p = textBoxElement.center;
            Rectangle2D properBounds = 
                new Rectangle2D.Double(p.x - w2, p.y - h2, 2 * w2, 2 * h2);  
            System.out.println(properBounds);
            textBoxElement.bounds = properBounds;
            bounds.add(properBounds);
            System.out.println("bounds now " + bounds);
        }
        return bounds;
    }

}
