package list.implementation;

public interface List<T> {

    void addFirst(T item);

    void addLast(T item);

    T getFirst();

    T getLast();

    T get(int i);

    int size();

    T removeLast();

    T removeFirst();

    default boolean isEmpty() {
        return size() == 0;
    }


}
