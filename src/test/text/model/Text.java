package test.text.model;

import javax.vecmath.Point2d;

/**
 * A test model object.
 * 
 * @author maclean
 *
 */
public class Text {
    
    public String text;
    
    public Point2d center;
    
    public Text(String text, Point2d center) {
        this.text = text;
        this.center = center;
    }

}
