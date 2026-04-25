class Solution {
    public static boolean dfs(int[] nums,int idx){
        if(idx==nums.length-1) return true; 
        if(idx>nums.length-1 || nums[idx]==0) return false;
        for(int j=1;j<=nums[idx];j++){
              if(dfs(nums,idx+j)) return true;
        }
        return false;
    }
    public boolean canJump(int[] nums) {
      return dfs(nums,0);  
    }
}
