package test.text.render;

import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

import painter.IBounder;

import diagram.Diagram;
import sketcher.AbstractSketcher;
import test.text.diagram.TextBoxElement;
import test.text.diagram.TextBoxListDiagram;
import test.text.model.TextBox;
import test.text.model.TextBoxBounder;

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
        Point2d center = getCenter(textBoxes);
        
        System.out.println("rough scale = " + scale + " model center = " + center);
        
        Diagram<TextBoxElement> diagram = new TextBoxListDiagram();
        Point2d cc = new Point2d(canvas.getCenterX(), canvas.getCenterY());
        for (TextBox textBox : textBoxes) {
            double x = ((textBox.center.x - center.x) * scale) + cc.x;
            double y = ((textBox.center.y - center.y) * scale) + cc.y;
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
}
