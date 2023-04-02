package disjointsets.implementation;


/**
 * WeightedQuickUnionPathCompressionDS is the same as WeightedQuickUnion with an
 * added optimization. The idea is when calling find on a given vertex
 * we set all the nodes on the path from root to vertex to be direct
 * children of the root, thus after calling connect and isConnected enough
 * times, all the elements will be direct children of the root.
 * The analysis is quite hard, but for all practical purposes you can
 * assume that the find operation will take almost amortized constant time
 * in the long term.
 *
 * @author aziz
 */
public class WeightedQuickUnionPathCompressionDS implements DisjointSets{

    /** Each element in this array represents the parent of the element at that index */
    private int parent[];
    /** size[i] represents the "weight" (number of elements) of the tree rooted at i */
    private int size[];

    /**
     * Initializes a disjoint set data structure with n elements
     * where each element is in its own set.<br>
     * Time complexity: &Theta;(<em>n</em>)
     * @param n the number of elements
     */
    public WeightedQuickUnionPathCompressionDS(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Merges the set containing the element {@code p} with the set
     * containing the element {@code q}.<br>
     * Time complexity: O(α(<em>n</em>)).
     * where α is the inverse Ackermann function.
     * @param p the first element
     * @param q the second element
     */
    @Override
    public void connect(int p, int q) {
        int proot = find(p);
        int qroot = find(q);
        if(proot == qroot) return; // This is not a constant time optimization as in QuickUnion!

        if (size[proot] < size[qroot]) {
            parent[proot] = qroot;
            size[qroot] += size[proot];
        } else {
            parent[qroot] = proot;
            size[proot] += size[qroot];
        }
    }

    /**
     * Finds the root of the vertex p and
     * then sets the parent of all the elements
     * on the path from p to root to be the root of p
     * and then returns the root.<br/>
     * Time complexity: O(α(<em>n</em>)).
     * where α is the inverse Ackermann function.
     * @param p an element
     * @return the root of the component
     */
    private int find(int p) {
        if(p == parent[p])
            return p;
        int proot = find(parent[p]);
        parent[p] = proot;
        return proot;
    }

    /**
     * Returns true if and only if the two elements are in the same set
     * (in the same tree in this specific implementation)<br/>
     * Time complexity: O(α(<em>n</em>)).
     * where α is the inverse Ackermann function.
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
