class Solution {
    public static int dfs(int []nums,int i,int dp[]){
      if(i>nums.length-1) return 0;
      if(dp[i]!=-1) return dp[i];
      int x=nums[i]+dfs(nums,i+2,dp);
      int y=dfs(nums,i+1,dp);
      return dp[i]=Math.max(x,y);
    }
    public static int dfs1(int []nums,int i,int dp[]){
      if(i>nums.length-2) return 0;
      if(dp[i]!=-1) return dp[i];
      int x=nums[i]+dfs1(nums,i+2,dp);
      int y=dfs1(nums,i+1,dp);
      return dp[i]=Math.max(x,y);
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int dp[]=new int [nums.length+1];
        Arrays.fill(dp,-1);
        int a=dfs1(nums,0,dp);
       Arrays.fill(dp,-1);
       int b=dfs(nums,1,dp);
       return Math.max(a,b);
    }
}
