class Solution {
    public int characterReplacement(String s, int k) {

        if (s.length() <= 1) return s.length();

        int ans = 0;

        for (char m = 'A'; m <= 'Z'; m++) {

            int i = 0, j = 0;
            int idx = k;

            while (j < s.length()) {

                if (s.charAt(j) != m) {
                    idx--;
                }

                while (idx < 0) {
                    if (s.charAt(i) != m) {
                        idx++;
                    }
                    i++;
                }

                ans = Math.max(ans, j - i + 1);
                j++;
            }
        }

        return ans;
    }
}
