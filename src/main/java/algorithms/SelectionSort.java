package algorithms;

import metrics.PerformanceTracker;

public class SelectionSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        int n = arr.length;
        tracker.start();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;


            for (int j = i + 1; j < n; j++) {
                tracker.incrementComparisons();
                tracker.incrementArrayAccesses(2);

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }


            if (minIndex != i) {
                swap(arr, i, minIndex, tracker);
            }
        }

        tracker.stop();
    }

    private static void swap(int[] arr, int i, int j, PerformanceTracker tracker) {
        tracker.incrementArrayAccesses(4);
        tracker.incrementSwaps();

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
