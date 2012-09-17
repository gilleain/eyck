package diagram.element;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Point2d;

import diagram.AbstractDiagramElement;

/**
 * A diagram element that is given a center when constructed.
 * 
 * @author maclean
 *
 */
public class LeafElement extends AbstractDiagramElement {
    
    public Point2d center;
    
    public Color outlineColor;
    
    public boolean isOutlined;
    
    public Color fillColor;
    
    public boolean isFilled;
    
    public LeafElement(Point2d center) {
	    this.center = center;
	    this.outlineColor = Color.BLACK;
	    this.fillColor = null;
	}

	public boolean isOutlined() {
		return isOutlined;
	}

	public void setOutlined(boolean isOutlined) {
		this.isOutlined = isOutlined;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}

	@Override
    public Point2d getCenter() {
        return center;
    }
    
    @Override
    public void add(IDiagramElement child) {
        // TODO - throw Exception?
    }

    @Override
    public int size() {
        return 1;
    }

    public Color getOutlineColor() {
        return outlineColor;
    }
    
    public void setOutlineColor(Color color) {
    	this.outlineColor = color;
    }

    public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	@Override
    public List<IDiagramElement> getChildren() {
        return new ArrayList<IDiagramElement>();
    }

}
