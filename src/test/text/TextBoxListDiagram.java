package test.text;

import java.util.ArrayList;
import java.util.List;

import diagram.Diagram;

public class TextBoxListDiagram implements Diagram<List<TextBox>> {
    
    private List<TextBoxDiagramElement> diagramElements;
    
    public TextBoxListDiagram() {
        this.diagramElements = new ArrayList<TextBoxDiagramElement>();
    }
    
    public void add(TextBoxDiagramElement element) {
        diagramElements.add(element);
    }

}
