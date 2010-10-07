package diagram;

import javax.vecmath.Point2d;

import diagram.element.IDiagramElement;

public interface IGenerator<T> {
    
    public IDiagramElement generate(T model, Point2d dc, double scale, Point2d cc);

}
