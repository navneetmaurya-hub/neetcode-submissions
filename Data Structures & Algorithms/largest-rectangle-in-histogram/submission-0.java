class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, zero = 0, ans = 0, min1 = Integer.MAX_VALUE;
        int k = 0;

        for(int i = 0; i < heights.length; i++){
            k = i;
            min = Integer.MAX_VALUE;   // reset correctly

            max = Math.max(max, heights[i]);
            min1 = Math.min(min1, heights[i]);

            if(heights[i] == 0) zero++;

            for(int j = i; j < heights.length; j++){

                if(heights[j] == 0){
                    break;  // rectangle cannot continue after 0
                }

                min = Math.min(min, heights[j]);

                ans = Math.max(ans, (j - i + 1) * min);  // correct width
            }
        }

        if(zero == 0){
            ans = Math.max(ans, heights.length * min1);
        }

        ans = Math.max(ans, max);

        return ans;
    }
}
