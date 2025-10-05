package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectionSortOptimizationTest {

    @Test
    void testOptimizationEffect() {
        int n = 5000;
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) sorted[i] = i;

        PerformanceTracker tracker = new PerformanceTracker();
        SelectionSort.sort(sorted, tracker);

        System.out.printf("Optimized SelectionSort on sorted array -> Time: %.3f ms%n",
                tracker.getElapsedTimeMillis());

        assertTrue(tracker.getComparisons() < n * (n - 1) / 2);
    }

    @Test
    void testRandomArray() {
        int n = 1000;
        int[] arr = new Random().ints(n, 0, 10000).toArray();

        PerformanceTracker tracker = new PerformanceTracker();
        SelectionSort.sort(arr, tracker);

        assertTrue(isSorted(arr));
    }

    private boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}
