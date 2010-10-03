package test.text;

import java.awt.geom.Rectangle2D;
import java.util.List;

import painter.BoundsCalculator;

public class TextBoxBoundsCalculator implements BoundsCalculator<List<TextBox>> {

    @Override
    public Rectangle2D getBounds(List<TextBox> textBoxes) {
        Rectangle2D bounds = new Rectangle2D.Double();
        
        for (TextBox textBox : textBoxes) {
            bounds.add(textBox.center.x, textBox.center.y);
        }
        
        return bounds;
    }

}