class Solution {
   public static int dfs(int i,int j,int row,int col,int dp[][],int ans[]){
      if(i<0 || j<0 || i>row-1 || j>col-1) return 0;
      if(i==row-1 && j==col-1){
         return 1;
      }
      if(dp[i][j]!=0) return dp[i][j];
      int x=dfs(i+1,j,row,col,dp,ans);
      int y=dfs(i,j+1,row,col,dp,ans);
      return dp[i][j]=x+y;
   }
    public int uniquePaths(int m, int n) {
       int dp[][]=new int[m][n];
       for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
            dp[i][j]=0;
         }
       }
       int ans[]=new int[1];
       return dfs(0,0,m,n,dp,ans); 
    }
}
