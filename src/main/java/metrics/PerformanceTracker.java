package metrics;

public class PerformanceTracker {
    private long startTime;
    private long elapsedTime;
    private long comparisons;
    private long swaps;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        elapsedTime = System.nanoTime() - startTime;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public double getElapsedTimeMillis() {
        return elapsedTime / 1_000_000.0;
    }

    @Override
    public String toString() {
        return String.format(
                "Time: %.3f ms | Comparisons: %d | Swaps: %d",
                getElapsedTimeMillis(), comparisons, swaps
        );
    }
}
