package test.text;

import java.util.List;

import javax.vecmath.Point2d;

import diagram.Diagram;
import sketcher.Sketcher;

public class TextBoxListSketcher 
       implements Sketcher<List<TextBox>, TextBoxElement> {

    @Override
    public Diagram<TextBoxElement> sketch(List<TextBox> textBoxes, double scale) {
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

}
