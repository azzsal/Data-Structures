package stack.implementation;

import list.implementation.List;
import list.implementation.SLList;

/**
 * The Stack represents a last-in-first-out stack of generic items.
 * It supports push, pop and top operations.
 * this implementation is based on singly linked lists,
 * using composition and delegation.
 * @param <T>
 * @author aziz
 */
public class LinkedStack<T> implements Stack<T>{

    private List<T> singlyLinkedList;

    public LinkedStack() {
        singlyLinkedList = new SLList<>();
    }

    /**
     * Adds the item to top of the stack.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @param item the item to be added
     */
    @Override
    public void push(T item) {
        singlyLinkedList.addFirst(item);
    }

    /**
     * Removes and returns the item at the top of
     * the stack if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item most recently added
     */
    @Override
    public T pop() {
        return singlyLinkedList.removeFirst();
    }

    /**
     * Returns the item at the top of the stack
     * if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item most recently added
     */
    @Override
    public T top() {
        return singlyLinkedList.getFirst();
    }

    /**
     * @return the number of items in the stack.
     */
    @Override
    public int size() {
        return singlyLinkedList.size();
    }
}
