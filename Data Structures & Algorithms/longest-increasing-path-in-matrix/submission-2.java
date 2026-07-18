class Solution {
    public static int dfs(int[][] matrix, int i, int j, int prev, int a,int dp[][][]) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length )
            return a;
        if (matrix[i][j] <= prev)
            return a;
        if(dp[i][j][a]!=-1) return dp[i][j][a];
        
        int curr = matrix[i][j];
        int p = dfs(matrix, i + 1, j, curr, a + 1,dp);
        int q = dfs(matrix, i, j + 1, curr,  a + 1,dp);
        int r = dfs(matrix, i - 1, j, curr,  a + 1,dp);
        int s = dfs(matrix, i, j - 1, curr,  a + 1,dp);

        

        return dp[i][j][a]=Math.max(Math.max(p, q), Math.max(r, s));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int dp[][][]=new int[matrix.length+1][matrix[0].length+1][10008];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
               Arrays.fill(dp[i][j],-1);
            } 
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {  
                ans = Math.max(ans,dfs(matrix, i, j, Integer.MIN_VALUE, 0,dp));
            }
        }

        return ans;
    }
}
