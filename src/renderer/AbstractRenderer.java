package renderer;

import painter.IPainter;
import sketcher.Sketcher;

public abstract class AbstractRenderer<T> implements IRenderer<T> {
    
    protected Sketcher sketcher;
    
    protected IPainter painter;
    
    @Override
    public void setSketcher(Sketcher sketcher) {
        this.sketcher = sketcher;
    }

    @Override
    public void setPainter(IPainter painter) {
        this.painter = painter;
    }

}
