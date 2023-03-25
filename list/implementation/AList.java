package list.implementation;

/** Array based implementation of a List data structure.
 * @param <T>
 * @author aziz
 */
public class AList<T> implements List<T> {

    private T[] items;
    private int size;

    public AList() {
        // You cannot create generic arrays,
        // because of the funny way java works (has to do with type erasure)
        items = (T[]) new Object[100];
        size = 0;
    }

    private void resize(int capacity) {
        T temp[] = (T[]) new Object[capacity];
        System.arraycopy(items, 0, temp, 0, items.length);
        items = temp;
    }

    /**
     * Adds an item to the back of the array based list.
     * Time complexity: amortized constant time O(1)
     * @param item the item to be added to the back
     */
    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[size] = item;
        size++;
    }

    /**
     * Adds an item to the front of the array based list.
     * Time complexity: linear time O(n)
     * @param item the item to be added to the front
     */
    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        for(int i = size-1; i >= 0; i--) {
            items[i+1] = items[i];
        }
        items[0] = item;
        size++;
    }


    /**
     * Gets the item at the front of the AList if present, else null.
     * @return the item at the front of the AList
     */
    @Override
    public T getFirst() {
        if (this.size == 0) {
            return null;
        }
        return items[0];
    }

    /**
     * Gets the item at the back of the AList if present, else null.
     * @return the item at the back of the AList
     */
    public T getLast() {
        if (this.size == 0) {
            return null;
        }
        return items[size-1];
    }

    /**
     * Gets the ith item in the list if present, else null.
     * @return the item at ith index
     */
    public T get(int i) {
        if (this.size == 0 || i < 0 || i >= size) {
            return null;
        }
        return items[i];
    }

    /**
     * @return the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and
     * returns deleted item if present, else returns null.
     * Time complexity: constant time O(1)
     * @return the deleted item if present, else null
     */
    public T removeLast() {
        if (this.size == 0) {
            return null;
        }
        T last = items[size-1];
        items[size-1] = null;
        size--;
        return last;
    }

    /**
     * Deletes item from front of the list and
     * returns deleted item if present, else returns null.
     * Time complexity: linear time O(n)
     * @return the deleted item if present, else null
     */
    @Override
    public T removeFirst() {
        if (this.size == 0) {
            return null;
        }
        T first = items[0];
        for(int i = 0; i < size-1; i++) {
            items[i] = items[i+1];
        }
        items[size-1] = null;
        size--;
        return first;
    }

} 