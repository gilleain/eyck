package layout;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLayout<T> implements ILayout<T> {
    
    private List<ILayout<T>> subLayouts;
    
    public AbstractLayout() {
        subLayouts = new ArrayList<ILayout<T>>();
    }
    
    public void addSubLayout(ILayout<T> subLayout) {
        subLayouts.add(subLayout);
    }
    
    public List<ILayout<T>> getSubLayouts() {
        return subLayouts;
    }

}
