package diagram;

import java.util.ArrayList;
import java.util.List;

public class DiagramTree<T> {
    
    private List<DiagramTree> children;
    
    private List<IDiagram<T>> diagrams;

    public DiagramTree() {
        children = new ArrayList<DiagramTree>();
        diagrams = new ArrayList<IDiagram<T>>();
    }
    
    public void addChild(DiagramTree child) {
        children.add(child);
    }
    
    public void addDiagram(IDiagram<T> diagram) {
        diagrams.add(diagram);
    }
    
    public List<DiagramTree> getChildren() {
        return children;
    }
    
    public List<IDiagram<T>> getDiagrams() {
        return diagrams;
    }
}
