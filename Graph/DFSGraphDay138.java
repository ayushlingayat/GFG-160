class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size(); // Number of vertices
        boolean[] visited = new boolean[V]; // To track visited nodes
        ArrayList<Integer> result = new ArrayList<>();
        
        // Perform DFS from node 0
        dfsHelper(0, adj, visited, result);
        
        return result;
    }

    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;  // Mark the node as visited
        result.add(node);  // Add the node to result

        // Traverse the adjacency list in the given order
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, result);
            }
        }
    }
    
}