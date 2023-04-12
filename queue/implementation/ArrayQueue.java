package queue.implementation;

/**
 * The Queue represents a first-in-first-out queue of generic items.
 * It supports enqueue, dequeue and nextFront operations.
 * this implementation is based on circular arrays.
 * @param <T>
 * @author aziz
 */
public class ArrayQueue<T> implements Queue<T> {

    private T[] items;
    private int size;
    private int nextFront;
    private int nextBack;

    public ArrayQueue() {
        items = (T[]) new Object[8];
        nextFront = 0;
        nextBack = 0;
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
        items[nextBack] = item;
        nextBack = (nextBack + 1) % items.length;
        size += 1;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int startIndex = nextFront;
        for(int i = 0; i < size; i++) {
            temp[i] = items[startIndex];
            startIndex = (startIndex + 1) % items.length;
        }
        items = temp;
        nextFront = 0;
        nextBack = size;
    }

    /**
     * Removes and returns the item at the nextFront of
     * the queue if present, else null.<br/>
     * Time complexity: amortized constant time &Theta;(<em>1</em>)
     * @return the item at nextFront of the queue
     */
    @Override
    public T dequeue() {
        if(isEmpty()) {
            return null;
        }
        T item = items[nextFront];
        nextFront = (nextFront + 1) % items.length;
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
     * Returns the item at the nextFront of the queue
     * if present, else null.<br/>
     * Time complexity: constant time &Theta;(<em>1</em>)
     * @return the item at nextFront of the queue
     */
    @Override
    public T front() {
        if(isEmpty()) {
            return null;
        }
        return items[nextFront];
    }

    /**
     * @return the number of items in the queue.
     */
    @Override
    public int size() {
        return this.size;
    }
}
