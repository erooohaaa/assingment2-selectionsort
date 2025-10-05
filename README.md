Assignment 2: Selection Sort (Student B)

Algorithm: Selection Sort (with early-termination optimization)
Language: Java (Maven project)
Status: ✅ Stable and functional — sorting, metrics, CLI benchmark, CSV export, unit tests

🧩 Project Overview

This project implements Selection Sort with a minor early-termination optimization, and integrates performance tracking for empirical analysis.
It is part of a paired academic assignment where each student implements one algorithm and analyzes the partner’s code.

📁 Repository Structure
assignment2-selectionsort/
├── pom.xml
├── src/
│   ├── main/java/
│   │   ├── algorithms/
│   │   │   └── SelectionSort.java
│   │   ├── metrics/
│   │   │   └── PerformanceTracker.java
│   │   └── cli/
│   │       └── BenchmarkRunner.java
│   └── test/java/
│       └── algorithms/
│           └── SelectionSortTest.java
├── docs/
│   └── performance-plots/
├── results.csv
└── README.md

⚙️ Build & Run

Requirements:

Java 17+

Maven 3.9+

Compile the project:

mvn clean compile


Run all unit tests:

mvn test


Run CLI benchmark:

mvn -q exec:java -Dexec.mainClass="cli.BenchmarkRunner"

💻 Command-Line Interface (CLI)

When you run the CLI, you can choose between:

Run single test — manually enter an array size

Run full benchmark (save to CSV) — automatically benchmarks multiple input sizes and writes results to results.csv

Output example in terminal:

Array size: 1000
Execution Time: 1.52 ms
Comparisons: 499500
Swaps: 999
Saved results to results.csv

📊 CSV Output Format

All benchmark results are stored in results.csv inside the project root.
Each line corresponds to one benchmark result.
### 📊 Benchmark Results (Selection Sort)

| Input Size (n) | Time (ms) | Comparisons | Swaps |
|----------------|-----------:|-------------:|-------:|
| 100            | 0          | 4,949        | 98     |
| 1,000          | 4          | 499,499      | 993    |
| 5,000          | 14         | 12,497,500   | 4,997  |
| 10,000         | 55         | 49,995,000   | 9,990  |
| 20,000         | 228        | 199,989,999  | 19,983 |

**Observation:**  
Execution time and the number of comparisons increase quadratically with input size, confirming the theoretical **O(n²)** time complexity of Selection Sort. The early termination optimization helps reduce comparisons on nearly-sorted data but has minimal effect on random arrays.
| Case                 | Time Complexity | Description                                                                                                                                                                 |
| -------------------- | --------------: | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Best Case (Ω)**    |       **Ω(n²)** | Even if array is sorted, Selection Sort must still scan remaining elements to find the minimum for each position (no early exit fundamentally changes asymptotic behavior). |
| **Average Case (Θ)** |       **Θ(n²)** | For random data, each element is compared with all remaining elements, leading to about *(n² / 2)* comparisons.                                                             |
| **Worst Case (O)**   |       **O(n²)** | In reverse-sorted arrays, the algorithm still performs n(n−1)/2 comparisons and n swaps.                                                                                    |
