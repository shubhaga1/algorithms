import java.util.*;

/**
 * DFS — Depth First Search
 *
 * IDEA: Go as deep as possible down one path before backtracking.
 *       Like exploring a maze — go until you hit a dead end, then backtrack.
 *
 * TOOLS:
 *   Recursive → uses call stack implicitly
 *   Iterative → uses explicit Stack
 *
 * USE CASES:
 *   ✅ Detect cycle in a graph
 *   ✅ Find connected components
 *   ✅ Topological sort (ordering with dependencies)
 *   ✅ Find all paths between two nodes
 *   ✅ Check if path exists
 *   ✅ Flood fill (paint bucket in Photoshop)
 *
 * TIME:  O(V + E)
 * SPACE: O(V) — recursion stack depth
 *
 * BFS vs DFS:
 *   BFS = shortest path, level by level, Queue
 *   DFS = explore fully, path finding, Stack/Recursion
 *
 * Run: javac 03_DFS.java && java DFS
 */
class DFS {

    static Map<Integer, List<Integer>> buildGraph() {
        // Graph:   1—2—5
        //          |   |
        //          3—4—6
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[][] edges = {{1,2},{1,3},{2,5},{3,4},{4,6},{5,6}};
        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            graph.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        return graph;
    }

    // ─── 1. DFS Recursive ────────────────────────────────────────────────────
    static void dfsRecursive(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(graph, neighbor, visited); // go DEEP before coming back
            }
        }
        // ← backtrack happens here automatically when for-loop ends
    }

    // ─── 2. DFS Iterative (using explicit Stack) ──────────────────────────────
    static void dfsIterative(Map<Integer, List<Integer>> graph, int start) {
        System.out.println("\n=== DFS ITERATIVE from node " + start + " ===");

        Stack<Integer> stack   = new Stack<>();
        Set<Integer>   visited = new HashSet<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();            // take from TOP

            if (visited.contains(node)) continue; // skip if already visited
            visited.add(node);
            System.out.print(node + " ");

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);      // push to TOP
                }
            }
        }
        System.out.println();
    }

    // ─── 3. DFS with trace — see backtracking ────────────────────────────────
    static void dfsTrace(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited, int depth) {
        visited.add(node);
        System.out.println("  ".repeat(depth) + "→ Visit " + node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsTrace(graph, neighbor, visited, depth + 1);
                System.out.println("  ".repeat(depth) + "← Back to " + node);
            }
        }
    }

    // ─── 4. Find all paths from start to end ─────────────────────────────────
    static List<List<Integer>> allPaths = new ArrayList<>();

    static void findAllPaths(Map<Integer, List<Integer>> graph, int cur, int end,
                              List<Integer> path, Set<Integer> visited) {
        path.add(cur);
        visited.add(cur);

        if (cur == end) {
            allPaths.add(new ArrayList<>(path)); // found a complete path
        } else {
            for (int neighbor : graph.getOrDefault(cur, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    findAllPaths(graph, neighbor, end, path, visited);
                }
            }
        }

        // BACKTRACK — remove current node so other paths can use it
        path.remove(path.size() - 1);
        visited.remove(cur);
    }

    // ─── 5. Detect cycle (undirected graph) ──────────────────────────────────
    // A cycle exists if we reach an already-visited node that isn't our parent
    static boolean hasCycle(Map<Integer, List<Integer>> graph, int node,
                             int parent, Set<Integer> visited) {
        visited.add(node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                if (hasCycle(graph, neighbor, node, visited)) return true;
            } else if (neighbor != parent) {
                // visited AND not our parent → cycle found
                return true;
            }
        }
        return false;
    }

    // ─── 6. Count connected components ───────────────────────────────────────
    // A connected component = group of nodes reachable from each other
    static int countComponents(Map<Integer, List<Integer>> graph, int totalNodes) {
        Set<Integer> visited    = new HashSet<>();
        int          components = 0;

        for (int node = 1; node <= totalNodes; node++) {
            if (!visited.contains(node)) {
                // Start DFS from this unvisited node — covers one component
                dfsHelper(graph, node, visited);
                components++;
            }
        }
        return components;
    }

    static void dfsHelper(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) dfsHelper(graph, neighbor, visited);
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = buildGraph();

        // 1. Recursive DFS
        System.out.println("=== DFS RECURSIVE from node 1 ===");
        dfsRecursive(graph, 1, new HashSet<>());
        System.out.println();

        // 2. Iterative DFS
        dfsIterative(graph, 1);

        // 3. DFS with backtracking visible
        System.out.println("\n=== DFS TRACE (see backtracking) from node 1 ===");
        dfsTrace(graph, 1, new HashSet<>(), 0);

        // 4. All paths
        System.out.println("\n=== ALL PATHS from 1 to 6 ===");
        findAllPaths(graph, 1, 6, new ArrayList<>(), new HashSet<>());
        for (List<Integer> path : allPaths) {
            System.out.println("  " + path);
        }

        // 5. Cycle detection
        System.out.println("\n=== CYCLE DETECTION ===");
        System.out.println("Graph has cycle: " + hasCycle(graph, 1, -1, new HashSet<>()));

        // Graph with no cycle (a tree: 1—2—3—4)
        Map<Integer, List<Integer>> tree = new HashMap<>();
        int[][] treeEdges = {{1,2},{2,3},{3,4}};
        for (int[] e : treeEdges) {
            tree.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            tree.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        System.out.println("Tree has cycle:  " + hasCycle(tree, 1, -1, new HashSet<>()));

        // 6. Connected components
        System.out.println("\n=== CONNECTED COMPONENTS ===");
        // Disconnected graph: {1,2,3} and {4,5} are separate
        Map<Integer, List<Integer>> disconnected = new HashMap<>();
        int[][] dcEdges = {{1,2},{2,3},{4,5}};
        for (int[] e : dcEdges) {
            disconnected.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            disconnected.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }
        // Need to ensure node 1-5 are in the map
        for (int i = 1; i <= 5; i++) disconnected.putIfAbsent(i, new ArrayList<>());
        System.out.println("Components in disconnected graph: " + countComponents(disconnected, 5));

        System.out.println("\n=== KEY POINTS TO REMEMBER ===");
        System.out.println("""
            1. Recursive DFS: visited.add BEFORE recursing into neighbors
               → Not after — or infinite loop

            2. Backtracking: remove node from path AFTER recursion returns
               → This is how all paths are found correctly

            3. Cycle detection: a visited neighbor that is NOT our parent = cycle
               → parent tracking avoids false positive (A→B→A in undirected)

            4. DFS vs BFS choice:
               → Need shortest path?          → BFS
               → Need all paths?              → DFS
               → Need cycle detection?        → DFS
               → Need connected components?   → either (DFS simpler)
            """);
    }
}
