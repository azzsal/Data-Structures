package list.implementation;

/** Circular-Linked List based implementation of the List ADT.
 * The idea behind the CLList is pretty smart. we notice in the
 * doubly linked list head and tail nodes, only one pointer is
 * used in each one, so we can instead make one node only making use
 * of both of its next and prev pointers, thus serving as both the
 * head and the tail nodes.
 * @param <T>
 * @author aziz
 */
public class CLList<T> implements List<T>{

    private class Node {
        T item;
        Node next;
        Node prev;

        public Node(T item, Node next, Node prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    /** serves as both the front and the back (makes use of both the next and prev pointers). */
    private Node sentinel;
    private int size;

    public CLList() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public CLList(T item) {
        this();
        addFirst(item);
    }

    /**
     * Adds an item to the front of the circular linked list.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @param item the item to be added to the front
     */
    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    /**
     * Add an item to the back of the circular linked list.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @param item the item to be added to the back
     */
    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    /**
     * Gets the item at the front of the CLList if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item at the front of the CLList
     */
    @Override
    public T getFirst() {
        if(size == 0) {
            return null;
        }
        return sentinel.next.item;
    }

    /**
     * Gets the item at the back of the CLList if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item at the back of the CLList
     */
    @Override
    public T getLast() {
        if(size == 0) {
            return null;
        }
        return sentinel.prev.item;
    }

    /**
     * Gets the ith item in the CLList if present, else null.<br/>
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
     * Deletes item from back of the CLList and
     * returns deleted item if present, else returns null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the deleted item if present, else null
     */
    @Override
    public T removeLast() {
        if(size == 0) {
            return null;
        }
        T temp = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return temp;
    }

    /**
     * Deletes item from front of the CLList and
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
        sentinel.next.prev = sentinel;
        size -= 1;
        return temp;
    }

}
