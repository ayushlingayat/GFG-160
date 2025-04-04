class Solution {
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Create adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];

        // Check for cycle in each component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCheck(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfsCheck(int src, List<List<Integer>> adj, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, -1});
        visited[src] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int curr = node[0];
            int parent = node[1];

            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, curr});
                } else if (neighbor != parent) {
                    return true;  // Cycle detected
                }
            }
        }
        return false;
    }
}
