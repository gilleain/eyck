package test.text.impl;

import javax.vecmath.Point2d;

/**
 * A test model object.
 * 
 * @author maclean
 *
 */
public class TextBox {
    
    public String text;
    
    public Point2d center;
    
    public TextBox(String text, Point2d center) {
        this.text = text;
        this.center = center;
    }

}
