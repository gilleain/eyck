package test.text;

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
        for (TextBoxDiagramElement textBoxElement : diagram) {
            Point2d p = textBoxElement.center;
            bounds.add(p.x, p.y);
        }
        return bounds;
    }

}
