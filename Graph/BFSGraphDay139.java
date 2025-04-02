class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V]; // Fixed: Define V properly
        ArrayList<Integer> res = new ArrayList<>();

        // Start BFS from node 0
        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int edges : adj.get(curr)) {
                if (!vis[edges]) {
                    vis[edges] = true;
                    q.add(edges);
                }
            }
        }

        return res;
    }
}
