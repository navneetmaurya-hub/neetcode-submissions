class Solution {
    public static void dfs(int[] nums, int target, int ans[], int i,int sum) {
        if (i == nums.length) {
            if (sum == target) ans[0]++;
            return;
        }
        dfs(nums, target, ans,i+1, sum + nums[i]);
        dfs(nums, target, ans,i+1, sum -nums[i]);
    }

    public int findTargetSumWays(int[] nums, int target) {
       int ans[] = new int[1];
        dfs(nums, target, ans,0, 0);
        return ans[0];
    }
}
