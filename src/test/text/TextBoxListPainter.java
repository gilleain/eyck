package test.text;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.vecmath.Point2d;

import painter.AbstractPainter;
import painter.IBounder;

public class TextBoxListPainter extends AbstractPainter<List<TextBox>> {
    
    private IBounder<List<TextBox>> modelBounder = new TextBoxBounder();
    
    private IBounder<TextBoxListDiagram> diagramBounder;
    
    private Graphics2D graphics;
    
    public TextBoxListPainter(Graphics2D graphics) {
        this.graphics = graphics;
        diagramBounder = new TextBoxListDiagramBounder(graphics);
    }

    @Override
    public void paint(List<TextBox> textBoxes, Rectangle2D canvas) {
        double scale = super.getScale(textBoxes, canvas);
        TextBoxListDiagram diagram = new TextBoxListDiagram();
        for (TextBox textBox : textBoxes) {
            double x = textBox.center.x * scale;
            double y = textBox.center.y * scale;
            TextBoxDiagramElement element = 
                new TextBoxDiagramElement(textBox.text, new Point2d(x, y));
            diagram.add(element);
        }
    }

    @Override
    public Rectangle2D getModelBounds(List<TextBox> model) {
        return modelBounder.getBounds(model);
    }

}
