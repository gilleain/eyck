package test.text.diagram;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import test.text.model.Text;

public class TextElement  {
    
    public Text textBox;
    
    public Point2d center;
    
    public Rectangle2D bounds;

    public TextElement(Text textBox, Point2d center) {
        this.textBox = textBox;
        this.center = center;
    }

}
