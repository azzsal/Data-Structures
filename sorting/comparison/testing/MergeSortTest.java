package sorting.comparison.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sorting.comparison.implementation.MergeSort;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    String[] input;
    Integer[] input2;
    Integer[] input3;

    String[] expected;
    Integer[] expected2;
    Integer[] expected3;

    @BeforeEach
    public void init() {
        input = new String[]{"i", "love", "to", "go", "to", "acpc"};
        input2 = new Integer[]{4, 3, 2, 1};
        input3 = new Integer[]{8, 7, 6, 5, 4, 3, 2, 1};

        expected = new String[]{"acpc", "go", "i", "love", "to", "to"};
        expected2 = new Integer[]{1, 2, 3, 4};
        expected3 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
    }

    @Test
    public void testSort() {

        MergeSort.mergeSort(input);
        assertArrayEquals(expected, input);

        MergeSort.mergeSort(input2);
        assertArrayEquals(expected2, input2);

        MergeSort.mergeSort(input3);
        assertArrayEquals(expected3, input3);
    }

    @Test
    public void testSort2() {

        MergeSort.mergeSort2(input);
        assertArrayEquals(expected, input);

        MergeSort.mergeSort2(input2);
        assertArrayEquals(expected2, input2);

        MergeSort.mergeSort2(input3);
        assertArrayEquals(expected3, input3);
    }

    @Test
    public void testSort3() {

        MergeSort.mergeSort3(input);
        assertArrayEquals(expected, input);

        MergeSort.mergeSort3(input2);
        assertArrayEquals(expected2, input2);

        MergeSort.mergeSort3(input3);
        assertArrayEquals(expected3, input3);
    }

}
