class Solution {
    public static void dfs(int[] nums, int target, int ans[], int i,int sum, List<Integer> curr) {

        if (i == nums.length) {
            if (sum == target) ans[0]++;
            return;
        }



            dfs(nums, target, ans,i+1, sum + nums[i], curr);
            dfs(nums, target, ans,i+1, sum -nums[i], curr);
    }

    public int findTargetSumWays(int[] nums, int target) {
        List<Integer> li = new ArrayList<>();

        for (int x : nums)
            li.add(x);

        int ans[] = new int[1];
        dfs(nums, target, ans,0, 0, li);
        return ans[0];
    }
}
