package recursion;

/**
 * Maze — Approach 1: Pure Recursion
 *
 * Question: how many ways can you go from (3,3) to (1,1)?
 * Moves allowed: UP (row-1) or LEFT (col-1) only.
 *
 * Key idea:
 *   ways(row, col) = ways(row-1, col) + ways(row, col-1)
 *   Base case: (1,1) = 1 way (you're already there)
 *
 * Problem: same subproblems computed repeatedly → see Maze2Memoization for fix
 */
class Maze1Recursive {

    // Count: how many paths exist from (row,col) to (1,1)?
    static int count(int row, int col) {
        if (row == 1 && col == 1) return 1;  // reached — 1 valid path
        if (row < 1  || col < 1)  return 0;  // out of bounds — dead end

        return count(row - 1, col)            // move up
             + count(row, col - 1);           // move left
    }

    // Print: what are the actual paths?
    // p builds the path string as we go: D = down (row-1), R = right (col-1)
    static void printPaths(String p, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(p);            // print completed path
            return;
        }

        if (row > 1) printPaths(p + "D", row - 1, col);  // move up
        if (col > 1) printPaths(p + "R", row, col - 1);  // move left
    }

    public static void main(String[] args) {
        int row = 3, col = 3;

        System.out.println("Total paths from (" + row + "," + col + ") to (1,1): "
                           + count(row, col));

        System.out.println("\nAll paths (D=up, R=left):");
        printPaths("", row, col);
    }
}
