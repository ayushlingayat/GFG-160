class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> revadj=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++)
            revadj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            revadj.get(v).add(u);
        }
        int visited[]=new int[V];
        Arrays.fill(visited,0);
        for(int i=0;i<V;i++)
            if(visited[i]==0)
                solve(visited,revadj,i,ans);
        return ans;
    }
    public static void solve(int visited[], ArrayList<ArrayList<Integer>> revadj, int u, ArrayList<Integer> ans)
    {
        for(int w:revadj.get(u))
        {
            if(visited[w]==0)
                solve(visited,revadj,w,ans);
        }
        visited[u]=1;
        ans.add(u);
    }
}