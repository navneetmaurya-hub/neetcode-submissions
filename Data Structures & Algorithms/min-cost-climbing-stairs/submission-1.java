class Solution {
    public static int dfs(int i,int dp[],int[] cost){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        dp[i]=cost[i]+Math.min(dfs(i+1,dp,cost),dfs(i+2,dp,cost));
        return dp[i];
    }

    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length+2];
        Arrays.fill(dp,-1);
        return Math.min(dfs(0,dp,cost),dfs(1,dp,cost));
    }
}
