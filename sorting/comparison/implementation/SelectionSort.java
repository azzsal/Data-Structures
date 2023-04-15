package sorting.comparison.implementation;

public class SelectionSort {

    /**
     * Sorts the array in place using selection sort algorithm.<br/>
     * Time complexity: quadratic time. &Theta;(<em>n^2</em>).
     * @param array the array to be sorted
     * @param <T>
     */
    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        selectionSort(array, 0);
    }

    private static <T extends Comparable<T>> void selectionSort(T[] array, int start) {
        if(start == array.length-1) {
            return;
        }
        int smallestIndex = findSmallestIndex(array, start);
        swap(array, start, smallestIndex);
        selectionSort(array, start+1);
    }

    private static <T extends Comparable<T>> int findSmallestIndex(T[] array, int start) {
        int smallestIndex = start;
        for(int i = start+1; i < array.length; i++) {
            if(array[i].compareTo(array[smallestIndex]) < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
