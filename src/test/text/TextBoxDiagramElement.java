package test.text;

import javax.vecmath.Point2d;

import diagram.Diagram;

public class TextBoxDiagramElement implements Diagram<TextBox> {
    
    private String text;
    
    private Point2d center;

    public TextBoxDiagramElement(String text, Point2d center) {
        this.text = text;
        this.center = center;
    }

}
