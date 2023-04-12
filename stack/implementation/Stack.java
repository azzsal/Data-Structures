package stack.implementation;

public interface Stack<T> {

    void push(T item);

    T pop();

    T top();

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }
}
