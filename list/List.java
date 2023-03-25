package list;

public interface List<T> {

    void addFirst(T item);

    void addLast(T item);

    T getFirst();

    T getLast();

    T get(int i);

    int size();

    void removeLast();

    void removeFirst();



}
