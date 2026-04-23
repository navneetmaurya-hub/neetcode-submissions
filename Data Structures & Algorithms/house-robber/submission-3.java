class Solution {
    public static int dfs(int []nums,int i,int dp[]){
        if(i>nums.length-1){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int x=nums[i]+dfs(nums,i+2,dp);
        int y=dfs(nums,i+1,dp);
        return dp[i]=Math.max(x,y);
    }
    public int rob(int[] nums) {
        int sum=0;
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return dfs(nums,0,dp);  
    }
}
