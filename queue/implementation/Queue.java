package queue.implementation;

public interface Queue<T> {

    void enqueue(T item);

    T dequeue();

    T front();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }
}
