package deque.implementation;


/**
 * Deque (usually pronounced like “deck”) is an irregular acronym of double-ended queue.
 * a deque supports insertion at both the front and the back with
 * dynamic resizing.
 * @param <T>
 * @author aziz
 */
public interface Deque<T> {

    /**
     * Adds an item of type T to the front of the deque,
     * You can assume that item is never null
     * Time complexity: O(1)
     * @param item
     */
    void addFirst(T item);

    /**
     * Adds an item of type T to back of the deque,
     * You can assume that item is never null.
     * Time complexity: O(1)
     * @param item
     */
    void addLast(T item);

    /**
     *
     * @return the number of items in the deque
     */
    int size();

    /**
     * Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
    void printDeque();

    /**
     * Removes and returns the item at the front of the deque,
     * If no such item exists, returns null.
     * Time complexity: O(1)
     * @return the first item in the deque if it exists, else null.
     */
    T removeFirst();

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     * Time complexity: O(1)
     * @return the last item in the deque if it exists, else null.
     */
    T removeLast();

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null
     * @param index
     * @return the item at index of the deque if it exists, else null.
     */
    T get(int index);

    /**
     * Returns whether the parameter o is equal to this deque.
     * o is considered equal if it is a Deque and if
     * it contains the same contents
     * (as governed by the generic T's equals method)
     * in the same order.
     * @param
     * @return
     */

    @Override
    boolean equals(Object o);

    /**
     * @return true if deque is empty, false otherwise
     */
    default boolean isEmpty() {
        return size() == 0;
    }

}
