package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {

    @Test
    void testSelectionSortBasic() {
        int[] arr = {5, 2, 4, 6, 1, 3};
        int[] expected = {1, 2, 3, 4, 5, 6};
        PerformanceTracker tracker = new PerformanceTracker();

        SelectionSort.sort(arr, tracker);
        assertArrayEquals(expected, arr);
        System.out.println(tracker);
    }

    @Test
    void testSelectionSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        PerformanceTracker tracker = new PerformanceTracker();

        SelectionSort.sort(arr, tracker);
        assertArrayEquals(expected, arr);
        System.out.println(tracker);
    }

    @Test
    void testSelectionSortEmptyArray() {
        int[] arr = {};
        PerformanceTracker tracker = new PerformanceTracker();

        SelectionSort.sort(arr, tracker);
        assertEquals(0, arr.length);
    }
}
