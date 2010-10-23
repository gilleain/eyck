package layout;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import painter.IBounder;
import diagram.element.IDiagramElement;

public abstract class AbstractLayout implements ILayout {
    
    private List<ILayout> subLayouts;
    
    public AbstractLayout() {
        subLayouts = new ArrayList<ILayout>();
    }
    
    public boolean isLeaf() {
        return subLayouts.size() == 0;
    }
    
    public void addSubLayout(ILayout subLayout) {
        subLayouts.add(subLayout);
    }
    
    public List<ILayout> getSubLayouts() {
        return subLayouts;
    }
    
    public Dimension getDimensions(
            IDiagramElement element, IBounder<IDiagramElement> bounder) {
        Rectangle2D bounds = bounder.getBounds(element);
        return new Dimension((int)bounds.getWidth(), (int)bounds.getHeight());
    }

}
