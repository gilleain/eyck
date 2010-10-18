package painter;

import java.awt.geom.Rectangle2D;

import layout.ILayout;

import diagram.DiagramTree;
import diagram.element.IDiagramElement;

public interface ICompositePainter<T> {
    
    void paint(DiagramTree<IDiagramElement> compositeDiagram, 
               Rectangle2D canvas, ILayout layout);

}
