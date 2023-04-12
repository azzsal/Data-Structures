package stack.implementation;

import list.implementation.CLList;
import list.implementation.List;

/**
 * The Stack represents a last-in-first-out stack of generic items.
 * It supports push, pop and top operations.
 * this implementation is based on circular linked lists,
 * using composition and delegation.
 * @param <T>
 * @author aziz
 */
public class LinkedStack<T> implements Stack<T>{

    private List<T> cLinkedList;

    public LinkedStack() {
        cLinkedList = new CLList<>();
    }

    /**
     * Adds the item to top of the stack.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @param item the item to be added
     */
    @Override
    public void push(T item) {
        cLinkedList.addLast(item);
    }

    /**
     * Removes and returns the item at the top of
     * the stack if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item most recently added
     */
    @Override
    public T pop() {
        return cLinkedList.removeLast();
    }

    /**
     * Returns the item at the top of the stack
     * if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item most recently added
     */
    @Override
    public T top() {
        return cLinkedList.getLast();
    }

    /**
     * @return the number of items in the stack.
     */
    @Override
    public int size() {
        return cLinkedList.size();
    }
}
