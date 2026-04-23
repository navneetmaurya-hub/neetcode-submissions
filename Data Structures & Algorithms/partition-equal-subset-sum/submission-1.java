class Solution {
    public static boolean dfs(int[] nums, int i, int target, int sum, Boolean dp[][]) {
        if(i >= nums.length || sum > target) return false;
        if(sum == target) return true;
        if(dp[i][sum] != null) return dp[i][sum];
        boolean notTake = dfs(nums, i + 1, target, sum, dp);
        boolean take = dfs(nums, i + 1, target, sum + nums[i], dp);
        return dp[i][sum] = (notTake || take);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        Boolean dp[][] = new Boolean[nums.length][target + 1];
        return dfs(nums, 0, target, 0, dp);
    }
}
