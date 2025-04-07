class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>() ; 
        int[] indegree = new int[V] ; 
        for(int i = 0 ; i < V ; i++){
            graph.add(new ArrayList<>()); 
        }
        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0] ; 
            int v = edges[i][1] ; 
            graph.get(u).add(v) ; 
            indegree[v]++ ;
        }
        Queue<Integer> q = new LinkedList<>() ; 
        for(int i = 0 ; i < V ; i++){
            if(indegree[i] == 0){
                q.offer(i); 
            }
        }
        List<Integer> result = new ArrayList<>() ; 
        while(!q.isEmpty()){
            int node = q.poll() ; 
            result.add(node) ;
            for(int nbr : graph.get(node)){
                indegree[nbr]-- ; 
                if(indegree[nbr] == 0){
                    q.offer(nbr) ; 
                }
            }
        }
        return result.size() != V ; 
        
    }
}
