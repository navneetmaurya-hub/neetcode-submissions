class Solution {
    public static int dfs(String s, String ans, HashMap<String, Integer> map, int idx, int dp[], int ans1[]) {
        if (s.length() == 0) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
            return 1;
        }
        if (dp[idx] != -1) return dp[idx];
        if (s.charAt(0) == '0') return 0;
        int x = dfs(s.substring(1), ans + s.charAt(0) + '*', map, idx + 1, dp, ans1);
        int y = 0;
        if (s.length() >= 2) {
            int num = Integer.parseInt(s.substring(0, 2));
            if (num >= 10 && num <= 26) {
                y = dfs(s.substring(2), ans + s.substring(0, 2) + '*', map, idx + 2, dp, ans1);
            }
        }
        ans1[0] = y; 
        return dp[idx] = x + y;
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        int ans1[] = new int[1];
        HashMap<String, Integer> map = new HashMap<>();
        return dfs(s, "", map, 0, dp, ans1);

    }
}
