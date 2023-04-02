package disjointsets.implementation;

/**
 * Weighted QuickUnion is the same as QuickUnion with an added optimization,
 * that guarantees the smaller (in size) tree is connected to the larger tree.
 * this is achieved by keeping track of an additional size array, so before
 * making a connect operation we check the sizes of the trees rooted at
 * p's root and q's root, and connect the smaller tree to the larger one.
 * By doing so we guarantee the height of the tree will be at most logN,
 * thus the find operation will have to climb logN at the worst case.
 * (there is a formal proof by strong induction for that,
 * but I think the following proof sketch is enough to convince you, well I hope:))
 *
 * (Proof sketch: Say we have an element x in a Tree T1.
 *  The depth of x increases by 1 only when T1 is placed below another tree T2.
 *  When that happens, the size of the resulting tree will be at least double the size of T1 because
 *  size(T2) >= size(T1). The tree with x can double at most logN times until we've reached a total of N items.
 *  So we can double up to logN times and each time, our tree adds a level → maximum logN levels.)
 *
 * @author aziz
 */
public class WeightedQuickUnionDS implements DisjointSets{

    private int parent[];
    private int size[];

    /**
     * Initializes a disjoint set data structure with n elements
     * where each element is in its own set.<br>
     * Time complexity: &Theta;(<em>n</em>)
     * @param n the number of elements
     */
    public WeightedQuickUnionDS(int n) {
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
     * (sets the smaller tree root to be a child of
     * the larger tree root, and then increments the larger
     * tree size by the smaller tree size).<br>
     * Time complexity: &Theta;(log<em>n</em>) in the worst case.
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
     * Returns the root of the component (which is canonical element of the set)<br/>
     * Time complexity: &Theta;(log<em>n</em>) in the worst case.
     * @param p an element
     * @return the root of the component
     */
    private int find(int p) {
        if(p == parent[p])
            return p;
        return find(parent[p]);
    }

    /**
     * Returns true if and only if the two elements are in the same set
     * (in the same tree in this specific implementation)<br/>
     * Time complexity: &Theta;(log<em>n</em>) in the worst case.
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
