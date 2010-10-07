package diagram;

import java.util.List;

public class ElementDiagram implements IDiagram<IDiagramElement> {
    
    private ElementSet root;
    
    public ElementDiagram(ElementSet root) {
        this.root = root;
    }

    @Override
    public List<IDiagramElement> getElements() {
        // TODO XXX this only returns the children of the root, not all elements!
        return root.getElements();
    }

    @Override
    public void add(IDiagramElement element) {
        root.add(element);
    }

    @Override
    public void addAll(List<IDiagramElement> elements) {
        // TODO Auto-generated method stub
        
    }

}
