package test.text.render;

import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

import painter.IBounder;

import diagram.Diagram;
import sketcher.AbstractSketcher;
import test.text.diagram.TextElement;
import test.text.diagram.TextListDiagram;
import test.text.model.Text;
import test.text.model.TextBounder;

public class TextBoxListSketcher 
       extends AbstractSketcher<List<Text>, TextElement> {
    
    private double scale;
    
    private IBounder<List<Text>> modelBounder;
    
    public TextBoxListSketcher() {
        modelBounder = new TextBounder();
    }

    @Override
    public Diagram<TextElement> sketch(List<Text> textBoxes, Rectangle2D canvas) {
        scale = getScale(textBoxes, canvas);
        Point2d center = getCenter(textBoxes);
        
        System.out.println("rough scale = " + scale + " model center = " + center);
        
        Diagram<TextElement> diagram = new TextListDiagram();
        Point2d cc = new Point2d(canvas.getCenterX(), canvas.getCenterY());
        for (Text textBox : textBoxes) {
            double x = ((textBox.center.x - center.x) * scale) + cc.x;
            double y = ((textBox.center.y - center.y) * scale) + cc.y;
            Point2d p = new Point2d(x, y);
            TextElement element = new TextElement(textBox, p);
            diagram.add(element);
        }
        return diagram;
    }

    @Override
    public Rectangle2D getModelBounds(List<Text> model) {
        return modelBounder.getBounds(model);
    }
}
