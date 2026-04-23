class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int ans[] = new int[n];

        for(int i = 0; i < n; i++){

            int j = i + 1;

            while(j < n && temperatures[j] <= temperatures[i]){
                j++;
            }

            if(j < n){
                ans[i] = j - i;
            }
        }

        return ans;
    }
}
