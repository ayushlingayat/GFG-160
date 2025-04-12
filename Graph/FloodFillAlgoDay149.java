class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int n=image.length,m=image[0].length;
        floodFill(sr,sc,image,image[sr][sc],newColor,new boolean[n][m],new int[][]{{0,1},{0,-1},{1,0},{-1,0}});
        return image;
    }
    private void floodFill(int i,int j,int mat[][],int cl,int nc,boolean vis[][],int dir[][]){
        if(i<0 || j<0 || i==mat.length || j==mat[0].length || mat[i][j]!=cl || vis[i][j]) return;
        mat[i][j]=nc;
        vis[i][j]=true;
        for(int[] d:dir) floodFill(i+d[0],j+d[1],mat,cl,nc,vis,dir);
    }
}
