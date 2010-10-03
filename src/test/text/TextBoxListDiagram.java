package test.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import diagram.Diagram;

public class TextBoxListDiagram 
       implements Diagram<List<TextBox>>, Iterable<TextBoxDiagramElement> {
    
    private List<TextBoxDiagramElement> diagramElements;
    
    public TextBoxListDiagram() {
        this.diagramElements = new ArrayList<TextBoxDiagramElement>();
    }
    
    public void add(TextBoxDiagramElement element) {
        diagramElements.add(element);
    }

    @Override
    public Iterator<TextBoxDiagramElement> iterator() {
        return diagramElements.iterator();
    }

}
