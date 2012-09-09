package divide;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class LinearDivider extends AbstractDivider {
    
    public enum Axis { LEFT_RIGHT, TOP_BOTTOM };
    
    private Axis axis;
    
    private List<Rectangle2D> canvases;
    
    public LinearDivider() {
        this(Axis.LEFT_RIGHT);
    }
    
    public LinearDivider(Axis axis) {
        this.axis = axis;
    }

    @Override
    public List<Rectangle2D> divide(Rectangle2D canvas, int n) {
        
        double dim;
        double centerX;
        double centerY;
        double axisCenter;
        
        if (axis == Axis.LEFT_RIGHT) {
            dim = canvas.getWidth() / n;
            centerX = canvas.getMinX() + (dim / 2);
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
        System.out.println("divided " + canvasToString(canvas)
        				  + "] into " + canvasesToString(canvases));
        return canvases;
    }
    
    private String canvasToString(Rectangle2D canvas) {
    	return "[" + canvas.getCenterX() + " " + canvas.getCenterY() + " "
		  		   + canvas.getWidth() + " " + canvas.getHeight() + "]";
    }
    
    private String canvasesToString(List<Rectangle2D> canvases) {
    	String s = "";
    	for (Rectangle2D canvas : canvases) {
    		s += canvasToString(canvas);
    	}
    	return s;
    }

}
