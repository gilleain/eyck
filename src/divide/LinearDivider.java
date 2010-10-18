package divide;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class LinearDivider implements IDivider {
    
    public enum Axis { LEFT_RIGHT, TOP_BOTTOM };
    
    private Axis axis;
    
    private List<Rectangle2D> canvases;
    
    private int n;
    
    public LinearDivider(int n) {
        this(n, Axis.LEFT_RIGHT);
    }
    
    public LinearDivider(int n, Axis axis) {
        this.n = n;
        this.axis = axis;
    }

    @Override
    public List<Rectangle2D> divide(Rectangle2D canvas) {
        
        double dim;
        double centerX;
        double centerY;
        double axisCenter;
        if (axis == Axis.LEFT_RIGHT) {
            dim = canvas.getWidth() / n;
            centerX = dim / 2;
            centerY = canvas.getMinY();
            axisCenter = canvas.getCenterY();
        } else {
            dim = canvas.getHeight() / n;
            centerY = dim / 2;
            centerX = canvas.getMinX();
            axisCenter = canvas.getCenterX();
        }
        
        double halfDim = dim / 2;
        
        canvases = new ArrayList<Rectangle2D>();
        for (int i = 0; i < n; i++) {
            double x;
            double y;
            if (axis == Axis.LEFT_RIGHT) {
                x = centerX - halfDim;
                y = axisCenter - halfDim;
            } else {
                x = axisCenter - halfDim;
                y = centerY - halfDim;
            }
            canvases.add(new Rectangle2D.Double(x, y, dim, dim));
            if (axis == Axis.LEFT_RIGHT) {
                centerX += dim;
            } else {
                centerY += dim;
            }
        }
        return canvases;
    }

}
