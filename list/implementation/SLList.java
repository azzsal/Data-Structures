package list.implementation;

/** Singly-Linked List based implementation of the List ADT.
 * @param <T>
 * @author aziz
 */
public class SLList<T> implements List<T>{

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /** sentinel node acts as a guard to avoid dealing with edge cases */
    private Node sentinel;
    private int size;

    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(T item) {
        this();
        addFirst(item);
    }

    /**
     * Adds an item to the front of the singly linked list.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @param item the item to be added to the front
     */
    @Override
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel.next);
        size += 1;
    }

    /**
     * Add an item to the back of the singly linked list.<br/>
     * Time complexity: linear time &Theta;(<em>n</em>)
     * @param item the item to be added to the back
     */
    @Override
    public void addLast(T item) {
        Node current = sentinel;
        while(current.next != null) {
            current = current.next;
        }
        current.next = new Node(item, null);
        size += 1;
    }

    /**
     * Gets the item at the front of the SLList if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item at the front of the SLList
     */
    @Override
    public T getFirst() {
        if (this.size == 0) {
            return null;
        }
        return sentinel.next.item;
    }

    /**
     * Gets the item at the back of the SLList if present, else null.<br/>
     * Time complexity: linear time &Theta;(<em>n</em>)
     * @return the item at the back of the SLList
     */
    @Override
    public T getLast() {
        if (this.size == 0) {
            return null;
        }
        Node current = sentinel;
        while(current.next != null) {
            current = current.next;
        }
        return current.item;
    }

    /**
     * Gets the ith item in the SLList if present, else null.<br/>
     * Time complexity: linear time &Theta;(<em>n</em>) in the worst case.
     * @return the item at ith index
     */
    @Override
    public T get(int i) {
        if (this.size == 0 || i < 0 || i >= size) {
            return null;
        }
        return get(sentinel.next, i);
    }

    private T get(Node current, int i) {
        if(i == 0) {
            return current.item;
        }
        return get(current.next, i - 1);
    }

    /**
     * @return the number of items in the list.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Deletes item from back of the SLList and
     * returns deleted item if present, else returns null.<br/>
     * Time complexity: linear time &Theta;(<em>n</em>)
     * @return the deleted item if present, else null
     */
    @Override
    public T removeLast() {
        if(size == 0) {
            return null;
        }
        Node current = sentinel;
        while(current.next.next != null) {
            current = current.next;
        }
        T temp = current.next.item;
        current.next = null;
        size -= 1;
        return temp;
    }

    /**
     * Deletes item from front of the SLList and
     * returns the deleted item if present, else returns null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the deleted item if present, else null
     */
    @Override
    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        T temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return temp;
    }
}
