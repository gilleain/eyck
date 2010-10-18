package divide;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDivider implements IDivider {
    
    private List<IDivider> subDividers;
    
    public AbstractDivider() {
        subDividers = new ArrayList<IDivider>();
    }

    @Override
    public void addSubDivider(IDivider subDivider) {
        subDividers.add(subDivider);
    }

    @Override
    public List<IDivider> getSubDividers() {
        return subDividers;
    }

}
