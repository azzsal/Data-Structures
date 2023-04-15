package sorting.comparison.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sorting.comparison.implementation.SelectionSort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest {

    String[] input;

    @BeforeEach
    public void init() {
        input = new String[]{"i", "love", "to", "go", "to", "acpc"};
    }

    @Test
    public void testSort() {
        String[] expected = {"acpc", "go", "i", "love", "to", "to"};

        SelectionSort.selectionSort(input);
        assertArrayEquals(expected, input);
    }
}
