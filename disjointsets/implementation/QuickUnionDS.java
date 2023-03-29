package disjointsets.implementation;

/**
 * QuickUnion is a concrete implementation of the QuickUnion ADT.
 * In quick union implementation, we think of connected components (disjoint sets)
 * as trees, and the value of element is its parent.
 * Initially each element is in its own tree, and when we connect
 * one element to the other we first find the root of first element's tree
 * then find the root of the second element's tree, and then set the root
 * of the first element to be a child of root of the second element.
 * (thus called quick union; the union is cheap, but find may be expensive)
 * To check whether two elements are connected, we first find their roots
 * and if they are the same then they are connected, otherwise not connected.
 * @author aziz
 */
public class QuickUnionDS implements DisjointSets{

    /** Each element in this array represents the parent of the element at that index */
    private int parent[];

    /**
     * Initializes a disjoint set data structure with n elements
     * where each element is in its own set.<br>
     * Time complexity: &Theta;(<em>n</em>)
     * @param n the number of elements
     */
    public QuickUnionDS(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * Merges the set containing the element {@code p} with the set
     * containing the element {@code q}<br>
     * (sets the parent of the first's element root to the
     * root of the second element in this specific implementation)
     * Time complexity: &Theta;(<em>n</em>) in the worst case.
     * @param p the first element
     * @param q the second element
     */
    @Override
    public void connect(int p, int q) {
        int proot = find(p);
        int qroot = find(q);
        if(proot == qroot) return;
        parent[proot] = qroot;
    }

    /**
     * Returns the root of the component (which is canonical element of the set)
     * Time complexity: &Theta;(<em>n</em>) in the worst case.
     * @param p an element
     * @return the root of the component
     */
    private int find(int p) {
        if (parent[p] == p)
            return p;
        return find(parent[p]);
    }

    /**
     * Returns true if and only if the two elements are in the same set<br>
     * (in the same tree in this specific implementation)
     * Time complexity: &Theta;(<em>n</em>) in the worst case.
     * @param p the first item
     * @param q the second item
     * @return {@code ture} if {@code p} and {@code q} are in the same set;
     *         {@code false} otherwise
     */
    @Override
    public boolean isConnected(int p, int q) {
        int proot = find(p);
        int qroot = find(q);
        return proot == qroot;
    }
}
