package test.text;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import painter.IBounder;

public class TextBoxListDiagramBounder implements
        IBounder<TextBoxListDiagram> {
    
    private Graphics2D graphics;
    
    public TextBoxListDiagramBounder(Graphics2D graphics) {
        this.graphics = graphics;
    }

    @Override
    public Rectangle2D getBounds(TextBoxListDiagram diagram) {
        
        return null;
    }

}
