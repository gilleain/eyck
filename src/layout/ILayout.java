package layout;

import java.util.List;

import javax.vecmath.Point2d;

import diagram.DiagramTree;
import diagram.IDiagram;

import painter.IBounder;

public interface ILayout<T> {
    
    public List<Point2d> layout(
            DiagramTree<T> obj, Point2d center, IBounder<IDiagram<T>> bounder);
    
    public void addSubLayout(ILayout<T> subLayout);
    
    public List<ILayout<T>> getSubLayouts();

}
