package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;
import java.util.Random;
import java.util.Scanner;

public class BenchmarkRunner {

    private static final int[] SIZES = {100, 1000, 5000, 10000};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Selection Sort Benchmark ===");
        System.out.println("1. Run single test");
        System.out.println("2. Run full benchmark");
        System.out.print("Choose option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> runSingleTest(scanner);
            case 2 -> runFullBenchmark();
            default -> System.out.println("Invalid option.");
        }
    }

    private static void runSingleTest(Scanner scanner) {
        System.out.print("Enter array size: ");
        int n = scanner.nextInt();
        int[] arr = generateRandomArray(n);

        PerformanceTracker tracker = new PerformanceTracker();
        SelectionSort.sort(arr, tracker);

        System.out.println("\nResult:");
        System.out.println(tracker);
    }

    private static void runFullBenchmark() {
        System.out.println("\nRunning benchmarks...");
        for (int size : SIZES) {
            int[] arr = generateRandomArray(size);
            PerformanceTracker tracker = new PerformanceTracker();

            SelectionSort.sort(arr, tracker);
            System.out.printf(
                    "n=%-6d | Time: %-8.3f ms | Comparisons: %-8d | Swaps: %-8d%n",
                    size,
                    tracker.getElapsedTimeMillis(),
                    tracker.getComparisons(),
                    tracker.getSwaps()
            );
        }
    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10_000);
        }
        return arr;
    }
}
