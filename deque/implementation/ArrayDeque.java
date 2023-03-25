package deque.implementation;

import java.util.Iterator;

/**
 * ArrayDeque is an implementation of Deque (double-ended queue),
 * data structure based on circular arrays.
 * Unlike regular arrays where the insertion at the front costs linear time,
 * a deque takes constant time.
 * Also unlike linked lists that don't support random access,
 * a deque supports that. So it has the best of both worlds!
 * The basic idea behind this data structure is a circular array,
 * where insertion at the front happens clockwise,
 * and insertion at the back happens counter clock wise.
 * @param <T>
 * @author aziz
 */
public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    /**
     * Adds an item to the front of the deque.
     * Time complexity: takes amortized constant time O(1)
     * @param item the item to be added to the front of the array deque
     */
    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        nextFirst = Math.floorMod(nextFirst - 1, items.length);
        size += 1;
    }

    /**
     * Adds an item to the back of the deque.
     * Time complexity: takes amortized constant time O(1)
     * @param item the item to be added to the back of the array-based deque
     */
    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    /**
     * Return the number of items in the array-based deque in constant time.
     * @return number of items in the deque
     */
    @Override
    public int size() {
        return this.size;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int count = 0;
        int startIndex = (nextFirst + 1) % items.length;
        for (int i = startIndex; count < size; i = (i + 1) % items.length) {
            temp[count] = items[i];
            count++;
        }
        nextFirst = capacity - 1;
        nextLast = count;
        items = temp;
    }


    /**
     * Prints the items in the array-based deque.
     */
    @Override
    public void printDeque() {
        for (T item : this) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /**
     * Removes the item at the front the array-based deque.
     * Time complexity: takes amortized constant time O(1)
     * @return item at the front of the deque if it exits, else null
     */
    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        int indexOfFirst = (nextFirst + 1) % items.length;
        T item = items[indexOfFirst];
        items[indexOfFirst] = null;
        nextFirst = indexOfFirst;
        size -= 1;
        if (items.length >= 16 && getUsageRatio() < 0.25) {
            resize(items.length / 2);
        }
        return item;
    }

    /**
     * Removes the item at the back the array-based deque.
     * Time complexity: takes amortized constant time O(1)
     * @return item at the back of the deque if it exits, else null
     */
    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        int indexOfLast = Math.floorMod(nextLast - 1, items.length);
        T item = items[indexOfLast];
        items[indexOfLast] = null;
        nextLast = indexOfLast;
        size -= 1;
        if (items.length >= 16 && getUsageRatio() < 0.25) {
            resize(items.length / 2);
        }
        return item;
    }

    private double getUsageRatio() {
        return (double) this.size / items.length;
    }

    /**
     * Gets the item at a given index.
     * Time complexity: constant time O(1)
     * @param index of the item to be returned
     * @return the item at the given index if it exits, else null.
     */
    @Override
    public T get(int index) {
        if (this.isEmpty() || index < 0 || index >= size) {
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];
    }

    /**
     *
     * @return an iterator over the calling deque.
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    /**
     * A custom iterator for array-based deque.
     */
    private class ArrayDequeIterator implements Iterator<T> {

        private int currentIndex;

        ArrayDequeIterator() {
            currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            T item = get(currentIndex);
            currentIndex += 1;
            return item;
        }
    }

    /**
     *
     * @param o the other object to check if it is equal or not.
     * @return true if the other object is a Deque,
     * and has the same elements in the same order.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Deque) {
            Deque<T> otherDeque = (Deque<T>) o;
            if (this.size() != otherDeque.size()) {
                return false;
            }
            for (int i = 0; i < this.size(); i++) {
                if (!this.get(i).equals(otherDeque.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
