package layout;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLayout implements ILayout {
    
    private List<ILayout> subLayouts;
    
    public AbstractLayout() {
        subLayouts = new ArrayList<ILayout>();
    }
    
    public void addSubLayout(ILayout subLayout) {
        subLayouts.add(subLayout);
    }
    
    public List<ILayout> getSubLayouts() {
        return subLayouts;
    }

}
