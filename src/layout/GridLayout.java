package layout;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class GridLayout implements ILayout {
    
    private int rows;
    
    private int cols;
    
    public GridLayout(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }
    
    public int getRowCount() {
        return rows;
    }
    
    public int getColCount() {
        return cols;
    }

    @Override
    public List<Rectangle2D> layout(Rectangle2D canvas) {
        double colWidth = canvas.getWidth() / cols;
        double rowHeight = canvas.getHeight() / rows;
        
        
        List<Rectangle2D> subCanvases = new ArrayList<Rectangle2D>();
        double y = canvas.getMinY();
        for (int row = 0; row < rows; row++) {
            double x = canvas.getMinX();
            for (int col = 0; col < cols; col++) {
                subCanvases.add(new Rectangle2D.Double(x, y, colWidth, rowHeight));
                x += colWidth;
            }
            y += rowHeight;
        }
        return subCanvases;
    }

}
