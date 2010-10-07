package diagram;

import java.awt.geom.Rectangle2D;

import javax.vecmath.Point2d;

import painter.IBounder;

public class DiagramBounder implements IBounder<IDiagram<IDiagramElement>> {

    @Override
    public Rectangle2D getBounds(IDiagram<IDiagramElement> diagram) {
        Rectangle2D bounds = null;
        
        for (IDiagramElement element : diagram.getElements()) {
            Rectangle2D elementBounds = element.getBounds();
            if (elementBounds == null) {
                Point2d center = element.getCenter();
                elementBounds = new Rectangle2D.Double(center.x, center.y, 0, 0);
            }
            
            if (bounds == null) {
                bounds = elementBounds;
            } else {
                bounds.add(elementBounds);
            }
        }
        
        return bounds;
    }

}
