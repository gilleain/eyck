package diagram;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import diagram.element.IDiagramElement;
import diagram.element.TextElement;

import painter.IBounder;

public class DiagramBounder implements IBounder<IDiagram<IDiagramElement>> {
    
 private Graphics graphics;
    
    public DiagramBounder(Graphics graphics) {
        this.graphics = graphics;
    }

    @Override
    public Rectangle2D getBounds(IDiagram<IDiagramElement> diagram) {
        Rectangle2D bounds = null;
        FontMetrics metrics = graphics.getFontMetrics();
        for (IDiagramElement element : diagram.getElements()) {
            Rectangle2D elementBounds = element.getBounds();
            if (element instanceof TextElement) {
                elementBounds = getBounds((TextElement) element, metrics);
            }
            if (elementBounds == null) {
                Point2d center = element.getCenter();
                elementBounds = new Rectangle2D.Double(center.x, center.y, 0, 0);
            }
            
            if (bounds == null) {
                bounds = elementBounds;
            } else {
                bounds.add(elementBounds);
            }
        }
        
        return bounds;
    }

    private Rectangle2D getBounds(TextElement element, FontMetrics metrics) {
        String text = element.text;
        Rectangle2D stringBounds = metrics.getStringBounds(text, graphics);
        double w2 = stringBounds.getWidth() / 2;
        double h2 = stringBounds.getHeight() / 2;
        Point2d p = element.getCenter();
        return new Rectangle2D.Double(p.x - w2, p.y - h2, 2 * w2, 2 * h2);  
    }

}
