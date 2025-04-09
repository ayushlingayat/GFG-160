class Solution {
    static int time;
    
    static void DFS(int u, ArrayList<ArrayList<Integer>> adj, int[] disc, int[] low,
                    int[] parent, boolean[] visited, boolean[] ap) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                DFS(v, adj, disc, low, parent, visited, ap);

                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1) {
                    ap[u] = true;
                }
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    ap[u] = true;
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // Build the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] ap = new boolean[V];
        Arrays.fill(parent, -1);
        time = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(i, adj, disc, low, parent, visited, ap);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                res.add(i);
            }
        }

        if (res.isEmpty()) {
            res.add(-1);
        }

        return res;
    }
}
