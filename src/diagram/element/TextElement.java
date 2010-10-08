package diagram.element;

import java.awt.Color;

import javax.vecmath.Point2d;

public class TextElement extends LeafElement {
    
    public String text;
    
    public TextElement(String text, Point2d center) {
        this(text, center, Color.BLACK);
    }
   
    public TextElement(String text, Point2d center, Color color) {
        super(center);
        this.text = text;
        this.color = color;
    }

}
