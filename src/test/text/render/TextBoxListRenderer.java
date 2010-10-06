package test.text.render;

import java.awt.geom.Rectangle2D;
import java.util.List;

import diagram.IDiagram;
import diagram.TextElement;

import painter.IPainter;

import renderer.IRenderer;
import sketcher.Sketcher;
import test.text.model.Text;

public class TextBoxListRenderer implements IRenderer<List<Text>> {
    
    private Sketcher sketcher;
    
    private IPainter painter;

    @Override
    public void setSketcher(Sketcher sketcher) {
        this.sketcher = sketcher;
    }

    @Override
    public void setPainter(IPainter painter) {
        this.painter = painter;
    }

    @Override
    public void render(List<Text> model, Rectangle2D canvas) {
        IDiagram<TextElement> diagram = sketcher.sketch(model, canvas);
        painter.paint(diagram, canvas);
    }

}
