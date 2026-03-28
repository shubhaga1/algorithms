# Data Structures & Algorithms — Java

Structured DSA implementations in Java, organized by topic and pattern.
Built for interview preparation targeting L5–L7 engineering roles.

---

## Structure

```text
algorithms/
├── array/              # Two sum, subarray, max subarray
├── recursion/          # Fibonacci, binary search, backtracking, N-Queens
├── sorting/            # Bubble, insertion, merge sort
├── searching/          # Linear search, binary search (recursive + iterative)
├── linkedlist/         # Cycle detection, partition list
├── stack/              # Valid parentheses, next smaller element
├── tree/               # Binary tree insert, traversal
├── hashmap/            # Frequency count, common elements, subarray sum
├── slidingWindow/      # Max sum in K, min subarray length, anagram
├── graph/              # Graph problems (WIP)
├── graph/              # BFS, Dijkstra, state design, river crossing
└── misc/               # Primes, collections, utilities
```

---

## Topics Covered

| Topic | Problems |
|---|---|
| Array | TwoSum, MaxSubArray, ZeroFilledSubarray, IsUnique, MedianArray |
| Recursion | Fibonacci, Factorial, BinarySearch, NQueens, Sudoku, RatInMaze |
| Sorting | BubbleSort, InsertionSort, MergeSort |
| Searching | LinearSearch, BinarySearch (recursive + iterative) |
| Linked List | CycleDetection, FirstNodeInCycle, PartitionList |
| Stack | ValidParentheses, NextSmallerElement, DeleteMiddleElement |
| Tree | Insert, Traversal |
| HashMap | HighestFrequencyChar, CommonElements, SubarraySum |
| Sliding Window | MaxSumInKArray, MinSubArrayLen, AnagramOccurrence |
| Backtracking | CombinationSum, ClimbingStairs, StairClimber |

---

## How to Run

```bash
# from the file's folder (no package declaration)
cd recursion
javac Fibonacci.java && java Fibonacci
```

---

## Interview Patterns

| Pattern | Folder | When to use |
|---|---|---|
| Two pointers | `array/` | sorted arrays, pair problems |
| Sliding window | `slidingWindow/` | subarray / substring problems |
| Fast + slow pointer | `linkedlist/` | cycle detection |
| Divide and conquer | `recursion/` | binary search, merge sort |
| Backtracking | `recursion/` | permutations, N-Queens, Sudoku |
| BFS / DFS | `graph/`, `tree/` | shortest path, traversal |

---

*By [Shubham Garg](https://www.linkedin.com/in/shubhaga/) — Engineering Manager*
