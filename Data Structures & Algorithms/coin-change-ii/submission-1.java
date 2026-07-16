class Solution {
    public static int dfs(int amount,int[] coins, int sum,int i,int dp[][]){
        if(sum==amount){
          return 1;
        }
        if(sum>amount || i>coins.length-1) return 0;
        if(dp[sum][i]!=-1) return dp[sum][i];
        int x=dfs(amount,coins,sum+coins[i],i,dp);
        int y=dfs(amount,coins,sum,i+1,dp);
      
      return dp[sum][i]=x+y;
    }
    public int change(int amount, int[] coins) {
        int dp[][]=new int[amount+1][coins.length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
      return dfs(amount,coins,0,0,dp); 
    }
}
