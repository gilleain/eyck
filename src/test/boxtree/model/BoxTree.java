package test.boxtree.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A dumb implementation of a tree-like hierarchy to test out the architecture
 * on tree-like models.
 * 
 * @author maclean
 *
 */
public class BoxTree {
    
    /**
     * Empty for the parents of leaves (boxes).
     */
    public List<BoxTree> children;
    
    /**
     * Can be null
     */
    public Box leaf;
    
    public BoxTree() {
        children = new ArrayList<BoxTree>();
    }

}
