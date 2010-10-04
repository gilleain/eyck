package diagram;

import java.util.List;

public interface Diagram<T> {
    
    public List<T> getElements();
    
    public void add(T element);

}
