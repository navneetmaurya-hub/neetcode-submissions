class Solution {
    public static void dfs(int i,int j,int[][] grid,int idx[]){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]!=1) return;
        grid[i][j]=2;
        idx[0]++;
        dfs(i+1,j,grid,idx);
        dfs(i,j+1,grid,idx);
        dfs(i-1,j,grid,idx);
        dfs(i,j-1,grid,idx);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
       for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==1){
                int idx[]=new int[1];
                dfs(i,j,grid,idx);
                ans=Math.max(ans,idx[0]);
            }
        }
       }
       return ans;
    }
}
