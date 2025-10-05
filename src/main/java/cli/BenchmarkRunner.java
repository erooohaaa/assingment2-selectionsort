package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class BenchmarkRunner {

    private static final int[] SIZES = {100, 1000, 5000, 10000, 20000};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Selection Sort Benchmark ===");
        System.out.println("1. Run single test");
        System.out.println("2. Run full benchmark (save to CSV)");
        System.out.print("Choose option: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter 1 or 2.");
            return;
        }

        switch (choice) {
            case 1 -> runSingleTest(scanner);
            case 2 -> runFullBenchmark();
            default -> System.out.println("Invalid option.");
        }
    }

    private static void runSingleTest(Scanner scanner) {
        System.out.print("Enter array size: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = generateRandomArray(n);

        PerformanceTracker tracker = new PerformanceTracker();
        tracker.startTimer();
        SelectionSort.sort(arr, tracker);
        tracker.stopTimer();

        System.out.println("\nResult:");
        System.out.println(tracker);
    }

    private static void runFullBenchmark() {
        System.out.println("\nRunning benchmarks and exporting results to results.csv...");

        try (FileWriter writer = new FileWriter("results.csv")) {
            writer.write("n,Time(ms),Comparisons,Swaps\n");

            for (int size : SIZES) {
                int[] arr = generateRandomArray(size);
                PerformanceTracker tracker = new PerformanceTracker();

                tracker.startTimer();
                SelectionSort.sort(arr, tracker);
                tracker.stopTimer();

                double time = tracker.getElapsedTimeMillis();
                long comparisons = tracker.getComparisons();
                long swaps = tracker.getSwaps();

                writer.write(String.format("%d,%.3f,%d,%d\n", size, time, comparisons, swaps));

                System.out.printf(
                        "n=%-6d | Time: %-8.3f ms | Comparisons: %-8d | Swaps: %-8d%n",
                        size, time, comparisons, swaps
                );
            }

            System.out.println("\n✅ Results saved to results.csv successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error writing to CSV: " + e.getMessage());
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
