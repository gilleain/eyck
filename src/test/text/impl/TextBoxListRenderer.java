package test.text.impl;

import java.awt.geom.Rectangle2D;
import java.util.List;

import diagram.Diagram;

import painter.IPainter;

import renderer.IRenderer;
import sketcher.Sketcher;

public class TextBoxListRenderer implements IRenderer<List<TextBox>> {
    
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
    public void render(List<TextBox> model, Rectangle2D canvas) {
        Diagram<TextBoxElement> diagram = sketcher.sketch(model, canvas);
        double scale = sketcher.getScale();
        
        painter.paint(diagram, canvas, scale);
    }

}
