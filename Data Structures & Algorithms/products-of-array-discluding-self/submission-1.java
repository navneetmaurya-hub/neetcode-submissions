class Solution {
    public int[] productExceptSelf(int[] nums) {
      int suf[]=new int[nums.length];
      int per[]=new int [nums.length];
      int ans[]=new int [nums.length];
      int d=1;
      for(int i=0;i<nums.length;i++){
          suf[i]=d*nums[i];
          d=suf[i];
      }
      int k=1;
      for(int i=nums.length-1;i>=0;i--){
          per[i]=k*nums[i];
          k=per[i];
      }
      ans[0]=per[1];
      ans[nums.length-1]=suf[nums.length-2];
      for(int i=1;i<nums.length-1;i++){
          ans[i]=per[i+1]*suf[i-1];
      }
      return ans;
    }
}  
