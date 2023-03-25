package deque.implementation;

import java.util.Iterator;


/**
 * LinkedListDeque is an implementation of Deque (double-ended queue),
 * data structure based on circular linked lists.
 * A linkedlist-based deque has a sentinel node the serves as
 * both the front and the back.
 * NOTE (Just For Fun!): "The monk at top of the hill told us that
 * the circular implementation is the wisest one of a linked list".
 * @param <T>
 * @author aziz
 */
public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    private static class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;

        Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(0, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Adds an item to the front of the deque.
     * Time complexity: takes constant time O(1)
     * @param item the item to be added to the front of the deque
     */
    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node(item, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    /**
     * Adds an item to the back of the deque.
     * Time complexity: takes constant time O(1)
     * @param item the item to be added to the back of the deque
     */
    @Override
    public void addLast(T item) {
        Node<T> newNode = new Node<>(item, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;

    }

    /**
     * Return the number of items in the linkedlist-based deque
     * in constant time.
     * @return number of items in the deque
     */
    @Override
    public int size() {
        return this.size;
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
     * Removes the item at the front the linked-based deque.
     * Time complexity: takes constant time O(1)
     * @return item at the front of the deque if it exits, else null
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return item;
    }

    /**
     * Removes the item at the back the linked-based deque.
     * Time complexity: takes constant time O(1)
     * @return item at the back of the deque if it exits, else null
     */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item = sentinel.prev.item;
        Node<T> newLast = sentinel.prev.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
        size -= 1;
        return item;
    }

    /**
     * Gets the item at a given index.
     * Time complexity: linear time O(n)
     * @param index of the item to be returned
     * @return the item at the given index if it exits, else null.
     */
    @Override
    public T get(int index) {
        int i = 0;
        Node<T> p = sentinel.next;
        while (sentinel.next != sentinel) {
            if (i == index) {
                return p.item;
            }
            p = p.next;
            i += 1;
        }
        return null;
    }

    private T getRecursive(Node<T> p, int index) {
        if (p == sentinel) {
            return null;
        }
        if (index == 0) {
            return p.item;
        }
        return getRecursive(p.next, index - 1);
    }

    /**
     * Gets the item at a given index, using recursion.
     * Time complexity: linear time O(n)
     * @param index of the item to be returned
     * @return the item at the given index if it exits, else null.
     */
    public T getRecursive(int index) {
        return getRecursive(sentinel.next, index);
    }

    /**
     * A custom iterator for array-based deque.
     */
    private class LinkedListDequeIterator implements Iterator<T> {

        private Node<T> currentNode = sentinel.next;

        @Override
        public boolean hasNext() {
            return currentNode != sentinel;
        }

        @Override
        public T next() {
            T item = currentNode.item;
            currentNode = currentNode.next;
            return item;
        }
    }

    /**
     *
     * @return an iterator over the calling deque.
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
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
