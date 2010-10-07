package diagram;

import diagram.element.IDiagramElement;

public interface IGenerator<T> {
    
    public IDiagramElement generate(T model);

}
