package test.text;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import diagram.Diagram;

public class TextBoxDiagramElement implements Diagram<TextBox> {
    
    public TextBox textBox;
    
    public Point2d center;
    
    public Rectangle2D bounds;

    public TextBoxDiagramElement(TextBox textBox, Point2d center) {
        this.textBox = textBox;
        this.center = center;
    }

}
