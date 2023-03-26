package disjointsets.implementation;

/**
 * QuickFind is a concrete implementation of the QuickUnion data structure.
 * From its name, it is efficient in find (isConnected) operation,
 * but inefficient in the union (connect) operation.
 * It models the disjoint sets with id's, where each set has a unique id.
 * Initially each element is in its own set (having a unique id), when
 * a union (connect) operation is performed, we iterate over the id's array
 * changing each element in the first set to be an element of the second's
 * element set (by setting its id to the second element set's id).
 * When a find (isConnected) operation is performed we simply check if
 * the two elements set's' are the same in constant time.
 * @author aziz
 */
public class QuickFindDS implements DisjointSets {

    /** Each element (represented by an index) is in a set,
     * and each set is identified by a unique id. */
    private int[] id;

    /**
     * Initializes a disjoint set data structure with n elements
     * where each element is in its own set.<br>
     * Time complexity: &Theta;(<em>n</em>)
     * @param N the number of elements
     */
    public QuickFindDS(int N) {
        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * Merges the set containing the element {@code p} with the set
     * containing the element {@code q}<br>
     * Time complexity: &Theta;(<em>n</em>)
     * @param p the first element
     * @param q the second element
     */
    @Override
    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        if (pid == qid) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
    }

    /**
     * Returns true if the two elements are in the same set<br>
     * Time complexity: &Theta;(<em>1</em>)
     * @param p the first item
     * @param q the second item
     * @return {@code ture} if {@code p} and {@code q} are in the same set;
     *         {@code false} otherwise
     */
    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }


}
