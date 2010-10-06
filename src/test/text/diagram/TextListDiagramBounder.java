package test.text.diagram;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import diagram.IDiagram;
import diagram.TextElement;

import painter.IBounder;

public class TextListDiagramBounder implements
        IBounder<IDiagram<TextElement>> {
    
    private Graphics graphics;
    
    public TextListDiagramBounder(Graphics graphics) {
        this.graphics = graphics;
    }

    @Override
    public Rectangle2D getBounds(IDiagram<TextElement> diagram) {
        Rectangle2D bounds = null;
        FontMetrics metrics = graphics.getFontMetrics();
        for (TextElement textBoxElement : diagram.getElements()) {
            String text = textBoxElement.text;
            Rectangle2D stringBounds = metrics.getStringBounds(text, graphics);
            double w2 = stringBounds.getWidth() / 2;
            double h2 = stringBounds.getHeight() / 2;
            Point2d p = textBoxElement.center;
            Rectangle2D properBounds = 
                new Rectangle2D.Double(p.x - w2, p.y - h2, 2 * w2, 2 * h2);  
            System.out.println(properBounds);
            textBoxElement.bounds = properBounds;
            if (bounds == null) {
                bounds = (Rectangle2D) properBounds.clone();
            } else {
                bounds.add(properBounds);
            }
            System.out.println("bounds now " + bounds);
        }
        return bounds;
    }

}
