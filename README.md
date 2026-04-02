# Algorithms & Java Learning — Shubham Garg

Java DSA implementations + clean code learning. Each file is runnable standalone.

---

## How to Run Any File

```bash
# From project root — fuzzy search by class name
rj Fibonacci          # finds and runs 02_Fibonacci.java
rj Sudoku             # finds and runs 18_Sudoku.java
rj BinarySearch       # finds and runs 06_BinarySearch.java

# Or explicitly
./run.sh recursion/02_Fibonacci.java
```

> `rj` is a shell alias in `~/.zshrc` — add it once and use everywhere.

---

## Project Structure

```
algorithms/
├── recursion/          # 01–18, ordered by difficulty
├── tree/               # BST, Trie, BTree
├── array/              # Two sum, subarray problems
├── sorting/            # Bubble, insertion, merge sort
├── searching/          # Linear, binary search
├── stack/              # Valid parentheses, next smaller element
├── hashmap/            # Frequency, common elements, subarray sum
├── slidingWindow/      # Max sum in K, min subarray length
├── graph/              # BFS, Dijkstra, traversal
├── patterns/           # Design patterns (Venkat workshop) — 01–09
├── fundamentals/       # Core Java gotchas (pass-by-value, static vs instance)
├── codequality/        # Clean code lessons Q1–Q5, 4 levels each
└── run.sh              # compile + run any file by class name
```

---

## Recursion — Learning Order (01 → 18)

| File | Concept |
|---|---|
| 01 Factorial | Basic recursion, base case |
| 02 Fibonacci | Recursion, exponential time |
| 03 ReverseNum | Digit manipulation |
| 04 DigitProduct | Single-digit base case |
| 05 ArraySortingCheck | Recursive array check |
| 06 BinarySearch | Recursive divide and conquer |
| 07 BinarySearchIterative | Same without recursion |
| 08 ValidPalindrome | Two-pointer recursion |
| 09 StairClimberBasic | Intro to DP — fib pattern |
| 10 StairClimber | DP with step array |
| 11 ClimbingStairs | Memoization with HashMap |
| 12 CombinationSum | Backtracking — pick/skip |
| 13 Maze1Recursive | Path counting + print all paths + visual grid |
| 14 Maze2Memoization | Top-down DP cache |
| 15 Maze3DPTable | Bottom-up iterative DP |
| 16 RatInAMaze | 4-direction backtracking |
| 17 NQueen | Constraint backtracking |
| 18 Sudoku | Full backtracking solver |

---

## Clean Code — codequality/ (Q1–Q5)

Each file has 4 levels of BAD → GOOD examples:

| File | Topic |
|---|---|
| Q1_MethodDoesOneThing | God method → hidden side effect → mutation → logic+format |
| Q2_BaseCases | Missing → buried → `\|\|` vs `&&` bug → shadowed case |
| Q3_Comments | Obvious → WHAT not WHY → outdated → good WHY comment |
| Q4_JavaSpecific | Magic numbers → static shared state → ArrayList vs List → sysout in lib |
| Q5_RecursionPatterns | Off-by-one → not converging → incomplete → no memoization |

---

## Java Fundamentals — fundamentals/

| File | What you learn |
|---|---|
| JavaPassByValueDemo | Why void recursive insert is broken — 3 cases |
| StaticVsInstance | When each object needs its own copy vs shared |

---

## Design Patterns — patterns/ (Venkat Workshop)

| File | Pattern |
|---|---|
| 01_NullVsOptional | Optional instead of null checks |
| 02_Iterator | Custom iterator pattern |
| 03_StrategyPattern | Swap algorithm at runtime |
| 04_FactoryPattern | Object creation abstraction |
| 05_LazyEvaluation | Compute only when needed |
| 06_DecoratorPattern | Add behavior without subclassing |
| 07_FluentInterface | Method chaining |
| 08_SealedClasses | Restricted type hierarchies (Java 17) |
| 09_PureFunctions | No side effects, predictable output |

---

## VS Code Setup (.vscode/)

### settings.json — Java LS config
```json
{
  "java.home": "/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home",
  "java.configuration.runtimes": [{ "name": "JavaSE-17", "path": "...", "default": true }],
  "java.project.sourcePaths": ["."],
  "java.project.outputPath": "target",
  "java.configuration.updateBuildConfiguration": "disabled",
  "java.compile.nullAnalysis.mode": "disabled"
}
```
- `java.home` — points LS to JDK 17 (fixes "Cannot find java.lang.Object")
- `updateBuildConfiguration: disabled` — stops LS re-scanning on every save
- `nullAnalysis: disabled` — reduces noise in learning files

### tasks.json — Cmd+Shift+B to compile + run
```json
"command": "javac -d target ${file} && java -cp target <ClassName>"
```
- Extracts class name from source (not filename) — handles `01_Fibonacci.java` → `Fibonacci`
- `Cmd+Shift+B` runs the currently open file

### launch.json — Run button
- Wires the VS Code Run ▶ button to the same compile+run flow

### .project + .classpath — Eclipse JDT project files
- Makes VS Code Java LS recognise this as a proper project (not "unmanaged folder")
- Eliminates "non-project file" and "declared package does not match" warnings
- Each source folder (`recursion/`, `tree/`, etc.) listed as a source root

### When VS Code Java LS breaks (it will):
```
Cmd+Shift+P → Java: Clean Java Language Server Workspace → Restart and Delete
```

---

## Git Setup

```bash
git config --global user.email "schmuck21@gmail.com"
git config --global user.name  "Shubham Garg"
```

### Rewriting past commit emails (for contribution graph)
```bash
git filter-branch -f --env-filter '
  export GIT_COMMITTER_EMAIL="schmuck21@gmail.com"
  export GIT_AUTHOR_EMAIL="schmuck21@gmail.com"
' --tag-name-filter cat -- --branches --tags

git push --force origin master
```
> GitHub contribution graph requires the commit email to match a verified email in your GitHub account Settings → Emails.

---

## Common Java Gotchas (learned here)

| Gotcha | Fix |
|---|---|
| `void` recursive insert doesn't work | Java passes refs by value — use `return Node` pattern |
| `stack.top()` doesn't exist | Java Stack uses `peek()` |
| `arr[i]` on ArrayList | Use `list.get(i)` |
| `public class` with numeric filename prefix | Remove `public` — class name must match filename exactly |
| Binary search on unsorted array | Sort first or use linear search |
| `||` in maze base case | Use `&&` — stop only when BOTH row AND col reach destination |
| Scanner resource leak | Wrap in `try (Scanner sc = new Scanner(System.in))` |
| Magic number `26` in Trie | Name it `ALPHABET_SIZE = 26` |
| `System.out` in helper methods | Only print in `main` — helpers should return values |

---

*By [Shubham Garg](https://www.linkedin.com/in/shubhaga/) *
