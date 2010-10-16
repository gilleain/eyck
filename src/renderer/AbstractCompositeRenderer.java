package renderer;

import painter.IPainter;
import sketcher.CompositeSketcher;

public abstract class AbstractCompositeRenderer<T> implements ICompositeRenderer<T> {
    
    protected CompositeSketcher sketcher;
    
    protected IPainter painter;
    
    public void setCompositeSketcher(CompositeSketcher sketcher) {
        this.sketcher = sketcher;
    }
    
    public void setPainter(IPainter painter) {
        this.painter = painter;
    }

}
