package algorithms;

import metrics.PerformanceTracker;

public class SelectionSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            boolean swapped = false;

            for (int j = i + 1; j < n; j++) {
                tracker.incrementComparisons();
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(arr, i, minIndex, tracker);
                swapped = true;
            }

            if (!swapped) break;
        }
    }

    private static void swap(int[] arr, int i, int j, PerformanceTracker tracker) {
        tracker.incrementSwaps();
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
