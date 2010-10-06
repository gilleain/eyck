package diagram;

import java.util.List;

public interface IDiagram<T> {
    
    public List<T> getElements();
    
    public void add(T element);
    
    public void addAll(List<T> elements);

}
