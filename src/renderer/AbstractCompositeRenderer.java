package renderer;

import painter.ICompositePainter;
import sketcher.CompositeSketcher;

public abstract class AbstractCompositeRenderer<T> implements ICompositeRenderer<T> {
    
    protected CompositeSketcher sketcher;
    
    protected ICompositePainter painter;
    
    public void setCompositeSketcher(CompositeSketcher sketcher) {
        this.sketcher = sketcher;
    }
    
    public void setCompositePainter(ICompositePainter painter) {
        this.painter = painter;
    }

}
