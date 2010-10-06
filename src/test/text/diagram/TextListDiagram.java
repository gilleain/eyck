package test.text.diagram;

import java.util.ArrayList;
import java.util.List;

import diagram.Diagram;

public class TextListDiagram implements Diagram<TextElement> {
    
    private List<TextElement> diagramElements;
    
    public TextListDiagram() {
        this.diagramElements = new ArrayList<TextElement>();
    }
    
    public void add(TextElement element) {
        diagramElements.add(element);
    }

    @Override
    public List<TextElement> getElements() {
        return diagramElements;
    }

    @Override
    public void addAll(List<TextElement> elements) {
        diagramElements.addAll(elements);
    }

}
