package searching.implementation;

import java.util.Comparator;

public class BinarySearch {

    public static <T extends Comparable<T>> int binarySearch(T[] array, T item) {
        return binarySearch(array, item, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> int binarySearch(T[] array, T item, int lo, int hi) {
        if(lo > hi) return -1;
        int mid = lo + ((hi - lo) / 2); // to avoid overflow

        int cmp = item.compareTo(array[mid]);
        if(cmp < 0) return binarySearch(array, item, lo, mid - 1);
        else if(cmp > 0) return binarySearch(array, item, mid + 1, hi);
        else return mid;
    }

    public static <T> int binarySearch(T[] array, T item, Comparator<T> comparator) {
        return binarySearch(array, item, comparator, 0, array.length - 1);
    }

    private static <T> int binarySearch(T[] array, T item, Comparator<T> comparator, int lo, int hi) {
        if(lo > hi) return -1 ;
        int mid = lo + ((hi - lo) / 2); // to avoid overflow

        int cmp = comparator.compare(item, array[mid]);
        if(cmp < 0) return binarySearch(array, item, comparator, lo, mid - 1);
        else if(cmp > 0) return binarySearch(array, item, comparator, mid + 1, hi);
        else return mid;
    }
}
