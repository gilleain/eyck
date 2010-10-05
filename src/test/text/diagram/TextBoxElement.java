package test.text.diagram;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import test.text.model.TextBox;

public class TextBoxElement  {
    
    public TextBox textBox;
    
    public Point2d center;
    
    public Rectangle2D bounds;

    public TextBoxElement(TextBox textBox, Point2d center) {
        this.textBox = textBox;
        this.center = center;
    }

}
