package test.text.diagram;

import java.util.ArrayList;
import java.util.List;

import diagram.Diagram;

public class TextBoxListDiagram implements Diagram<TextBoxElement> {
    
    private List<TextBoxElement> diagramElements;
    
    public TextBoxListDiagram() {
        this.diagramElements = new ArrayList<TextBoxElement>();
    }
    
    public void add(TextBoxElement element) {
        diagramElements.add(element);
    }

    @Override
    public List<TextBoxElement> getElements() {
        return diagramElements;
    }

    @Override
    public void addAll(List<TextBoxElement> elements) {
        diagramElements.addAll(elements);
    }

}
