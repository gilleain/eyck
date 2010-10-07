package diagram;

import java.util.ArrayList;
import java.util.List;

import diagram.element.ElementSet;
import diagram.element.IDiagramElement;

public class ElementDiagram implements IDiagram<IDiagramElement> {
    
    private ElementSet root;
    
    public ElementDiagram(ElementSet root) {
        this.root = root;
    }

    @Override
    public List<IDiagramElement> getElements() {
        // TODO XXX this only returns the children of the root, not all elements!
        List<IDiagramElement> all = new ArrayList<IDiagramElement>();
        getElements(root, all);
        return all;
    }
    
    private void getElements(IDiagramElement element, List<IDiagramElement> all) {
        if (element instanceof ElementSet) {
            for (IDiagramElement child : ((ElementSet)element).getElements()) {
                getElements(child, all);
            }
        } else {
            all.add(element);
        }
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
