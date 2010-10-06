package diagram;

import javax.vecmath.Point2d;

public class TextElement extends LeafElement {
    
    public String text;
   
    public TextElement(String text, Point2d center) {
        super(center);
        this.text = text;
    }

}
