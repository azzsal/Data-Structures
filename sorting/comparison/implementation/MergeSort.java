package sorting.comparison.implementation;

/**
 * This utility class has a couple of merge sort implementations
 * (from the worst to the best).
 * Note that there is an in-place merge-sort,
 * that does not use extra space, but it is
 * a bit complicated to implement.
 *
 * @author aziz
 */
public class MergeSort {

    /**
     * This is the most naive top-down implementation of merge sort.
     * It rearranges the array in ascending order, using the natural order.
     * where natural order is, the ordering implied in the compareTo method.<br/>
     * Time complexity: &Theta;(<em>nlogn</em>)<br/>
     * Space complexity: since this implementation creates arrays at each
     * recursive call it uses extra space of: N + N/2 + N/4 + N/8 + ... + 1,
     * which is of order &Theta;(<em>n</em>)
     * @param array the array to be sorted
     * @param <T>
     */
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length == 1) {
            return;
        }
        int N = array.length;
        int leftSize = N/2, rightSize = N-(N/2);
        T[] leftArr = (T[]) new Comparable[leftSize];
        T[] rightArr = (T[]) new Comparable[rightSize];
        for(int i = 0, k = 0; i < N; i++) {
            if(i < leftSize) {
                leftArr[i] = array[i];
            } else {
                rightArr[k++] = array[i];
            }
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, array);
    }

    private static <T extends Comparable<T>> void merge(T[] leftArr, T[] rightArr, T[] resultArr) {
        int i = 0, l = 0, r = 0;
        while(l < leftArr.length && r < rightArr.length) {
            if(leftArr[l].compareTo(rightArr[r]) < 0) {
                resultArr[i++] = leftArr[l++];
            } else {
                resultArr[i++] = rightArr[r++];
            }
        }
        while(l < leftArr.length) {
            resultArr[i++] = leftArr[l++];
        }
        while(r < rightArr.length) {
            resultArr[i++] = rightArr[r++];
        }
    }

    /**
     * This is a better top-down implementation of merge sort.
     * It rearranges the array in ascending order, using the natural order.
     * where natural order is, the ordering implied in the compareTo method.<br/>
     * Time complexity: &Theta;(<em>nlogn</em>)<br/>
     * Space complexity: it uses exactly N extra space,
     * thus it is in the order of &Theta;(<em>n</em>)
     * @param array the array to be sorted
     * @param <T>
     */
    public static <T extends Comparable<T>> void mergeSort2(T[] array) {
        T[] aux = (T[]) new Comparable[array.length];
        mergeSort2(array, aux, 0, array.length-1);
    }

    private static <T extends Comparable<T>> void mergeSort2(T[] array, T[] aux, int lo, int hi) {
        // base case: one element
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        // sort left half
        mergeSort2(array, aux, lo, mid);
        // sort right half
        mergeSort2(array, aux, mid + 1, hi);
        // merge left and right
        merge2(array, aux, lo, mid, hi);
    }

    private static <T extends Comparable<T>> void merge2(T[] array, T[] aux, int lo, int mid, int hi) {
        // copy go aux[]
        for(int i = lo; i <= hi; i++) {
            aux[i] = array[i];
        }
        // this is another implementation of merging,
        // you could've used the same one above with three while loops.
        // merge back to array[]
        int l = lo, r = mid + 1;
        for(int i = lo; i <= hi; i++) {
            if(l > mid) {
                array[i] = aux[r++];
            } else if(r > hi) {
                array[i] = aux[l++];
            } else if(aux[l].compareTo(aux[r]) < 0) {
                array[i] = aux[l++];
            } else {
                array[i] = aux[r++];
            }
        }
    }

    /**
     * This implementation is an optimized version of the above implementation,
     * it switches the roles of the array and aux at each level of the recursion,
     * thus requiring only N time to copy to aux (instead of NlogN).
     * Time complexity: &Theta;(<em>nlogn</em>)<br/>
     * Space complexity: it uses exactly N extra space,
     * thus it is in the order of &Theta;(<em>n</em>)
     * @param array the array to be sorted
     * @param <T>
     */
    public static <T extends Comparable<T>> void mergeSort3(T[] array) {
        T[] aux = array.clone();
        mergeSort3(array, aux, 0, array.length-1);
    }

    private static <T extends Comparable<T>> void mergeSort3(T[] array, T[] aux, int lo, int hi) {
        if(hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort3(aux, array, lo, mid);
        mergeSort3(aux, array, mid+1, hi);
        merge3(array, aux, lo, mid, hi);
    }

    private static <T extends Comparable<T>> void merge3(T[] array, T[] aux, int lo, int mid, int hi) {
        int l = lo, r = mid + 1;
        for(int i = lo; i <= hi; i++) {
            if(l > mid) {
                array[i] = aux[r++];
            } else if(r > hi) {
                array[i] = aux[l++];
            } else if(aux[l].compareTo(aux[r]) < 0) {
                array[i] = aux[l++];
            } else {
                array[i] = aux[r++];
            }
        }
    }

}
