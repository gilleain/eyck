package layout;

import java.awt.Dimension;
import java.util.List;

import javax.vecmath.Point2d;

import diagram.element.IDiagramElement;

import painter.IBounder;

public interface ILayout {
    
    public List<Point2d> layout(IDiagramElement obj, 
                                Point2d center, 
                                IBounder<IDiagramElement> bounder);
    
    public void addSubLayout(ILayout subLayout);
    
    public List<ILayout> getSubLayouts();
    
    public Dimension getDimensions(
            IDiagramElement element, IBounder<IDiagramElement> bounder);

}
