package queue.implementation;

/**
 * The Queue represents a first-in-first-out queue of generic items.
 * It supports enqueue, dequeue and front operations.
 * this implementation is based on circular arrays.
 * @param <T>
 * @author aziz
 */
public class ArrayQueue<T> implements Queue<T> {

    private T[] items;
    private int size;
    private int front;
    private int back;

    public ArrayQueue() {
        items = (T[]) new Object[8];
        front = 0;
        back = 0;
        size = 0;
    }

    /**
     * Adds the item to rear of the queue.<br/>
     * Time complexity: amortized constant time &Theta;(<em>1</em>)
     * @param item the item to be added
     */
    @Override
    public void enqueue(T item) {
        if(size == items.length) {
            resize(items.length * 2);
        }
        items[back] = item;
        back = (back + 1) % items.length;
        size += 1;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int startIndex = front;
        for(int i = 0; i < size; i++) {
            temp[i] = items[startIndex];
            startIndex = (startIndex + 1) % items.length;
        }
        items = temp;
        front = 0;
        back = size;
    }

    /**
     * Removes and returns the item at the front of
     * the queue if present, else null.<br/>
     * Time complexity: amortized constant time &Theta;(<em>1</em>)
     * @return the item at front of the queue
     */
    @Override
    public T dequeue() {
        if(isEmpty()) {
            return null;
        }
        T item = items[front];
        front = (front + 1) % items.length;
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
     * Returns the item at the front of the queue
     * if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item at front of the queue
     */
    @Override
    public T front() {
        if(isEmpty()) {
            return null;
        }
        return items[front];
    }

    /**
     * @return the number of items in the queue.
     */
    @Override
    public int size() {
        return this.size;
    }
}
