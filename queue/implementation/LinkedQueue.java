package queue.implementation;

import list.implementation.CLList;
import list.implementation.List;

/**
 * The Queue represents a first-in-first-out queue of generic items.
 * It supports enqueue, dequeue and front operations.
 * this implementation is based on circular linked lists,
 * using composition and delegation.
 * @param <T>
 * @author aziz
 */
public class LinkedQueue<T> implements Queue<T>{

    List<T> clinkedList;

    public LinkedQueue() {
        clinkedList = new CLList<>();
    }

    /**
     * Adds the item to rear of the queue.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @param item the item to be added
     */
    @Override
    public void enqueue(T item) {
        clinkedList.addLast(item);
    }

    /**
     * Removes and returns the item at the front of
     * the queue if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item at front of the queue
     */
    @Override
    public T dequeue() {
        return clinkedList.removeFirst();
    }

    /**
     * Returns the item at the front of the queue
     * if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item at front of the queue
     */
    @Override
    public T front() {
        return clinkedList.getFirst();
    }

    /**
     * @return the number of items in the queue.
     */
    @Override
    public int size() {
        return clinkedList.size();
    }
}
