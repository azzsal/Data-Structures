package set;


/**
 * An object that stores values with no duplicates.
 * @param <E> the type of values
 *
 * @author aziz
 */
public interface Set<E> extends Iterable<E> {

    /**
     * Removes all the values from the set.
     */
    void clear();

    /**
     * Returns true if this set contains the specified element.
     * @param element element to check if this set contains it
     * @return true if this set contains the element.
     */
    boolean contains(E element);

    /**
     * Returns the number of elements in this set.
     * @return the number of mappings in this set.
     */
    int size();

    /**
     * Add the specified element in this set, if not already present.
     * @param element element to add
     */
    void add(E element);

    /**
     * Removes the element from this set, and returns its value,
     * else return null if element is not present.
     * @param element element to remove
     * @return the value of the element if present, else null
     */
    E remove(E element);
}
