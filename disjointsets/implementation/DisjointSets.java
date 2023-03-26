package disjointsets.implementation;


/**
 *  A Disjoint-Sets (or Union-Find) data structure keeps track of
 *  a fixed number of elements partitioned into a number of disjoint sets.
 *  It has two main functions, connect (aka. union); connects two elements together,
 *  and isConnected (aka. find); checks whether two elements are connected.
 * @author aziz
 */
public interface DisjointSets {

    /**
     * Connects two elements P and Q
     * @param p the first element
     * @param q the second element
     */
    void connect(int p, int q);

    /**
     * Checks to see if two are connected
     * @param p the first element
     * @param q the second element
     */
    boolean isConnected(int p, int q);

}