package test.text.model;

import java.awt.geom.Rectangle2D;
import java.util.List;

import painter.IBounder;

public class TextBoxBounder implements IBounder<List<TextBox>> {

    @Override
    public Rectangle2D getBounds(List<TextBox> textBoxes) {
        Rectangle2D bounds = new Rectangle2D.Double();
        
        for (TextBox textBox : textBoxes) {
            bounds.add(textBox.center.x, textBox.center.y);
        }
        
        return bounds;
    }

}
