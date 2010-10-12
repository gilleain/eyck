package diagram;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Point2d;

import diagram.element.IDiagramElement;

public class DiagramList implements IDiagramElement, IDiagram<IDiagramElement> {
    
    private List<IDiagram<IDiagramElement>> diagrams;
    
    public DiagramList() {
        diagrams = new ArrayList<IDiagram<IDiagramElement>>();
    }
    
    public List<IDiagram<IDiagramElement>> getDiagrams() {
        return diagrams;
    }
    
    public void addDiagram(IDiagram<IDiagramElement> diagram) {
        diagrams.add(diagram);
    }
    
    public int size() {
        return diagrams.size();
    }

    @Override
    public List<IDiagramElement> getElements() {
        List<IDiagramElement> all = new ArrayList<IDiagramElement>();
        for (IDiagram<IDiagramElement> diagram : diagrams) {
            all.addAll(diagram.getElements());
        }
        return all;
    }

    @Override
    public void add(IDiagramElement element) {
        // TODO Auto-generated method stub
        // XXX : not sure what to do here : add as a whole new diagram?
    }

    @Override
    public void addAll(List<IDiagramElement> elements) {
        // TODO Auto-generated method stub
        // XXX : not sure what to do here : add as a whole new diagram?        
    }

    @Override
    public Rectangle2D getBounds() {
        return null;
    }

    @Override
    public Point2d getCenter() {
        // TODO Auto-generated method stub
        return null;
    }

}
