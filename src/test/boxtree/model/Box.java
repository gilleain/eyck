package test.boxtree.model;

import java.awt.geom.Rectangle2D;

/**
 * A model object representing, well, a box.
 * 
 * @author maclean
 *
 */
public class Box {
    
    public Rectangle2D rectangle;
    
    public Box(Rectangle2D rectangle) {
        this.rectangle = rectangle;
    }

}
