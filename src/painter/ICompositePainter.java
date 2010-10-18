package painter;

import java.awt.geom.Rectangle2D;


import diagram.DiagramTree;
import diagram.element.IDiagramElement;
import divide.IDivider;

public interface ICompositePainter<T> {
    
    void paint(DiagramTree<IDiagramElement> compositeDiagram, 
               Rectangle2D canvas, IDivider divider);

}
