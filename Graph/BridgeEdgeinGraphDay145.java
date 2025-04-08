class Solution {
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // code here
        
                // Create adjacency list after removing edge (c, d)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            if ((u == c && v == d) || (u == d && v == c)) continue;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // BFS or DFS to check if d is reachable from c
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(c);
        vis[c] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adj.get(node)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }

        // If node 'd' is not visited, then (c, d) is a bridge
        return vis[d] ? 0 : 1;
    }
}
