class Pair{
    int i;
    int j;
    int t;
    Pair(int i, int j, int t){
        this.i = i;
        this.j = j;
        this.t = t;
    }
}
class Solution {
    public int orangesRotting(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int vis[][] = new int[n][m];
        int count = 0;
        Queue<Pair>q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 2){
                    vis[i][j] = 2;
                    q.add(new Pair(i,j,0));
                }
                if(mat[i][j] == 1) count++;
            }
        }
        int max = 0;
        int tc = 0;
        while(!q.isEmpty()){
            Pair temp = q.remove();
            int i = temp.i;
            int j = temp.j;
            int t = temp.t;
            max = Math.max(max,t);
            if(i-1>=0 && mat[i-1][j] == 1 && vis[i-1][j] != 2){
                vis[i-1][j] = 2;
                q.add(new Pair(i-1,j,t+1));
                tc++;
            }
            if(i+1<n && mat[i+1][j] == 1 && vis[i+1][j] != 2){
                vis[i+1][j] = 2;
                q.add(new Pair(i+1,j,t+1));
                tc++;
            }
            if(j-1>=0 && mat[i][j-1] == 1 && vis[i][j-1] != 2){
                vis[i][j-1] = 2;
                q.add(new Pair(i,j-1,t+1));
                tc++;
            }
            if(j+1<m && mat[i][j+1] == 1 && vis[i][j+1] != 2){
                vis[i][j+1] = 2;
                q.add(new Pair(i,j+1,t+1));
                tc++;
            }
        }
        if(count != tc) return -1;
        return max;
    }
}