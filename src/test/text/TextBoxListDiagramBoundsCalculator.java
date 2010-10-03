package test.text;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import painter.BoundsCalculator;

public class TextBoxListDiagramBoundsCalculator implements
        BoundsCalculator<TextBoxListDiagram> {
    
    private Graphics2D graphics;
    
    public TextBoxListDiagramBoundsCalculator(Graphics2D graphics) {
        this.graphics = graphics;
    }

    @Override
    public Rectangle2D getBounds(TextBoxListDiagram diagram) {
        
        return null;
    }

}
