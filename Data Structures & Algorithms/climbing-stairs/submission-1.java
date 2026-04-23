class Solution {
    public static int dfs(int i,int dp[],int n ){
        if(i>n) return 0;
        if(i==n){
          return 1;
        }
        if(dp[i]!=-1) return dp[i];
       dp[i]=dfs(i+1,dp,n)+dfs(i+2,dp,n);
       return dp[i];
    }
    public int climbStairs(int n) {
        int ans[]=new int [1];
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
         return dfs(0,dp,n);
    }
}
