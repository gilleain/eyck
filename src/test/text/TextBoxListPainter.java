package test.text;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import painter.AbstractPainter;
import painter.BoundsCalculator;

public class TextBoxListPainter extends AbstractPainter<List<TextBox>> {
    
    private BoundsCalculator<List<TextBox>> boundsCalculator =
        new TextBoxBoundsCalculator();
    
    private Graphics2D graphics;
    
    public TextBoxListPainter(Graphics2D graphics) {
        this.graphics = graphics;
    }

    @Override
    public void paint(List<TextBox> textBoxes, Rectangle2D canvas) {
        double scale = super.getScale(textBoxes, canvas);
        TextBoxListDiagram diagram = new TextBoxListDiagram();
        
    }

    @Override
    public Rectangle2D getModelBounds(List<TextBox> model) {
        return boundsCalculator.getBounds(model);
    }

}
