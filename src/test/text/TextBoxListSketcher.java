package test.text;

import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

import painter.IBounder;

import diagram.Diagram;
import sketcher.AbstractSketcher;

public class TextBoxListSketcher 
       extends AbstractSketcher<List<TextBox>, TextBoxElement> {
    
    private double scale;
    
    private IBounder<List<TextBox>> modelBounder;
    
    public TextBoxListSketcher() {
        modelBounder = new TextBoxBounder();
    }

    @Override
    public Diagram<TextBoxElement> sketch(List<TextBox> textBoxes, Rectangle2D canvas) {
        scale = getScale(textBoxes, canvas);
        System.out.println("rough scale = " + scale);
        
        Diagram<TextBoxElement> diagram = new TextBoxListDiagram();
        for (TextBox textBox : textBoxes) {
            double x = textBox.center.x * scale;
            double y = textBox.center.y * scale;
            Point2d p = new Point2d(x, y);
            TextBoxElement element = new TextBoxElement(textBox, p);
            diagram.add(element);
        }
        return diagram;
    }

    @Override
    public Rectangle2D getModelBounds(List<TextBox> model) {
        return modelBounder.getBounds(model);
    }

    @Override
    public double getScale() {
        return scale;
    }

}
