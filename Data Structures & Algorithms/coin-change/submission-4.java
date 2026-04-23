class Solution {
    public static int dfs(int[] coins, int amount, int ans[], long sum, int idx, int dp[]) {
        if (sum > amount) return Integer.MAX_VALUE;
        if ((int) sum == amount) {
            return 0;
        }
        if (dp[(int)sum] != -1) return dp[(int)sum];
        int min = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            int res = dfs(coins, amount, ans, sum + coins[i], idx + 1, dp);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + res);
            }
        }
        return dp[(int)sum] = min;
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int ans[] = new int[1];
        ans[0] = Integer.MAX_VALUE;
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, -1);
        int result = dfs(coins, amount, ans, 0, 0, dp);
        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }
}
  