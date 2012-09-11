package divide;

import java.util.List;

/**
 * A divider breaks a canvas up into parts.
 * 
 * @author maclean
 *
 */
public interface IDivider {
    
    public void addSubDivider(IDivider subDivider);
    
    public List<IDivider> getSubDividers();

}
