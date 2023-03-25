package deque;

import java.util.Comparator;

/**
 * MaxArrayDeque is very similar to a regular ArrayDeque,
 * except it has one more extra feature, it can return
 * the max element in array-based deque by providing a custom comparator.
 * @param <T>
 * @author aziz
 */
public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Gets the max item in an array-based deque based on the
     * comparator given in the constructor.
     * Time complexity: linear time O(n)
     * @return the max item
     */
    public T max() {
        return max(comparator);
    }

    /**
     * Gets the max item in an array-based deque based on the
     * comparator given as the argument.
     * Time complexity: linear time O(n)
     * @param customComparator the comparator to compare
     *                         the items in the deque upon.
     * @return the max item based on the comparator given
     */
    public T max(Comparator<T> customComparator) {
        if (this.isEmpty()) {
            return null;
        }
        T maxElement = this.get(0);
        for (T item : this) {
            if (customComparator.compare(item, maxElement) > 0) {
                maxElement = item;
            }
        }
        return maxElement;
    }
}
