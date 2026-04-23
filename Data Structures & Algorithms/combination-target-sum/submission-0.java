class Solution {
    public static void dfs(int[] nums, List<List<Integer>>li,List<Integer>lii, HashSet<List<Integer>>hs,int sum,int j,int target){
      if(j>nums.length-1 || sum>target) return;
      if(sum==target){
        if(!hs.contains(lii)){
            li.add(new ArrayList<>(lii));
            hs.add(lii);
           
        }
         return;
      }
        dfs(nums,li,lii,hs,sum,j+1,target);
        lii.add(nums[j]);
        sum=sum+nums[j];
        dfs(nums,li,lii,hs,sum,j+1,target);
        dfs(nums,li,lii,hs,sum,j,target);
        lii.remove(lii.size()-1);
      }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       List<List<Integer>>li=new ArrayList<>();
       List<Integer>lii=new ArrayList<>();
       HashSet<List<Integer>>hs=new HashSet<>();
       dfs(nums,li,lii,hs,0,0,target);
       return li;  
    }
}
