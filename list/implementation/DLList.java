package list.implementation;

/** Doubly-Linked List based implementation of the List ADT.
 * @param <T>
 * @author aziz
 */
public class DLList<T> implements List<T>{

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

    private Node head;
    private Node tail;
    private int size;

    public DLList() {
        head = new Node(null, null, null);
        tail = new Node(null, null, head);
        head.next = tail;
        size = 0;
    }

    public DLList(T item) {
        this();
        addFirst(item);
    }

    /**
     * Adds an item to the front of the doubly linked list.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @param item the item to be added to the front
     */
    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, head.next, head);
        head.next.prev = newNode;
        head.next = newNode;
        size += 1;
    }

    /**
     * Add an item to the back of the doubly linked list.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @param item the item to be added to the back
     */
    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, tail, tail.prev);
        tail.prev.next = newNode;
        tail.prev = newNode;
        size += 1;
    }

    /**
     * Gets the item at the front of the DLList if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item at the front of the DLList
     */
    @Override
    public T getFirst() {
        if(size == 0) {
            return null;
        }
        return head.next.item;

    }

    /**
     * Gets the item at the back of the DLList if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item at the back of the DLList
     */
    @Override
    public T getLast() {
        if(size == 0) {
            return null;
        }
        return tail.prev.item;
    }

    /**
     * Gets the ith item in the DLList if present, else null.<br/>
     * Time complexity: linear time &Theta;(<em>n</em>) in the worst case.
     * @return the item at ith index
     */
    @Override
    public T get(int i) {
        if (this.size == 0 || i < 0 || i >= size) {
            return null;
        }
        return get(head.next, i);
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
     * Deletes item from back of the DLList and
     * returns deleted item if present, else returns null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the deleted item if present, else null
     */
    @Override
    public T removeLast() {
        if(size == 0) {
            return null;
        }
        T temp = tail.prev.item;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size -= 1;
        return temp;
    }

    /**
     * Deletes item from front of the DLList and
     * returns the deleted item if present, else returns null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the deleted item if present, else null
     */
    @Override
    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        T temp = head.next.item;
        head.next = head.next.next;
        head.next.prev = head;
        size -= 1;
        return temp;
    }
}
