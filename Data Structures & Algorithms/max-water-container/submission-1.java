class Solution {
    public int maxArea(int[] heights) {
      int i=0,ans=Integer.MIN_VALUE;
      int j=0;
      
      while(i<heights.length-1){
        j++;
       int min=Math.min(heights[i],heights[j]);
       ans=Math.max(ans,min*(j-i));
       if(j==heights.length-1){
        i++;
        j=i;
       }
      }
      return ans; 
    }
}
