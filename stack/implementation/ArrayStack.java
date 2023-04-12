package stack.implementation;

import list.implementation.AList;
import list.implementation.List;

/**
 * The Stack represents a last-in-first-out stack of generic items.
 * It supports push, pop and top operations.
 * this implementation is based on arrayLists
 * using composition and delegation.
 * @param <T>
 * @author aziz
 */
public class ArrayStack<T> implements Stack<T> {

    private List<T> aList;

    public ArrayStack() {
        aList = new AList<>();
    }

    /**
     * Adds the item to top of the stack.<br/>
     * Time complexity: amortized constant &Theta;(<em>1</em>)
     * @param item the item to be added
     */
    @Override
    public void push(T item) {
        aList.addLast(item);
    }

    /**
     * Removes and returns the item at the top of
     * the stack if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item most recently added
     */
    @Override
    public T pop() {
        return aList.removeLast();
    }

    /**
     * Returns the item at the top of the stack
     * if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item most recently added
     */
    @Override
    public T top() {
        return aList.getLast();
    }

    /**
     * @return the number of items in the stack.
     */
    @Override
    public int size() {
        return aList.size();
    }
}
