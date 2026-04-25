class Solution {
    static int dp [][];
    public static int dfs(int[] nums,int idx,int ans[],int count){
        if(idx==nums.length-1){
            return count;
        } 
        if(idx>nums.length-1 || nums[idx]==0) return Integer.MAX_VALUE;
        if(dp[idx][count]!=-1) return dp[idx][count];
        for(int j=1;j<=nums[idx];j++){
              ans[0]=Math.min(dfs(nums,idx+j,ans,count+1),ans[0]);
        }
        return dp[idx][count]=ans[0];
    }
    public int jump(int[] nums) {
        dp=new int[nums.length+1][nums.length+1];
        for(int i=0;i<=nums.length;i++){
          Arrays.fill(dp[i],-1);
        }
        if(nums.length<=1) return 0;
        int ans[]=new int[1];
        ans[0]=Integer.MAX_VALUE;
        dfs(nums,0,ans,0);
        return ans[0]; 
    }
}
