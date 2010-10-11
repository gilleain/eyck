package layout;

import java.awt.geom.Rectangle2D;
import java.util.List;

import diagram.DiagramList;
import diagram.IDiagram;
import diagram.element.IDiagramElement;

public class LinearLayout implements ILayout<DiagramList> {
    
    public enum Axis { LEFT_RIGHT, TOP_BOTTOM };
    
    private Axis axis;
    
    private List<Rectangle2D> canvases;
    
    public LinearLayout(Axis axis) {
        this.axis = axis;
    }

    @Override
    public void layout(DiagramList diagramList, Rectangle2D canvas) {
        List<IDiagram<IDiagramElement>> diagrams = diagramList.getDiagrams();
        
        double dim;
        double centerX;
        double centerY;
        double axisCenter;
        if (axis == Axis.LEFT_RIGHT) {
            dim = canvas.getWidth() / diagrams.size();
            centerX = dim / 2;
            centerY = canvas.getMinY();
            axisCenter = canvas.getCenterY();
        } else {
            dim = canvas.getHeight() / diagrams.size();
            centerY = dim / 2;
            centerX = canvas.getMinX();
            axisCenter = canvas.getCenterX();
        }
        
        double halfDim = dim / 2;
        
        for (IDiagram<IDiagramElement> diagram : diagrams) {
            double x;
            double y;
            if (axis == Axis.LEFT_RIGHT) {
                x = centerX - halfDim;
                y = axisCenter;
            } else {
                x = axisCenter;
                y = centerY - halfDim;
            }
            canvases.add(new Rectangle2D.Double(x, y, dim, dim));
            if (axis == Axis.LEFT_RIGHT) {
                centerX += dim;
            } else {
                centerY += dim;
            }
        }
    }

}
