class Solution {
    public int findMin(int[] nums) {
       int st=0,end=nums.length-1;
       int ans=Integer.MAX_VALUE;
       while(st<=end){
         int mid=st+(end-st)/2;
         if(nums[mid]>nums[end]){
            st=mid+1;
            ans=Math.min(ans,nums[mid]);
         }
         else{
            end=mid-1;
            ans=Math.min(ans,nums[mid]);
         }
       }
       return ans;
    }
}
