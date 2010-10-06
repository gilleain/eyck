package test.text.model;

import java.awt.geom.Rectangle2D;
import java.util.List;

import painter.IBounder;

public class TextBounder implements IBounder<List<Text>> {

    @Override
    public Rectangle2D getBounds(List<Text> textBoxes) {
        Rectangle2D bounds = new Rectangle2D.Double();
        
        for (Text textBox : textBoxes) {
            bounds.add(textBox.center.x, textBox.center.y);
        }
        
        return bounds;
    }

}
