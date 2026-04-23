class Solution {
    public int[] twoSum(int[] nums, int target) {
       int ans[]=new int[2];
       HashMap<Integer,Integer>map=new HashMap<>();
       for(int i=0;i<nums.length;i++){
           map.put(nums[i],i);
       }
       for(int i=0;i<nums.length;i++){
           map.remove(nums[i],i);
           if(map.containsKey(target-nums[i])){
              ans[0]=i;
              ans[1]=map.get(target-nums[i]);
              break;
           }
           map.put(nums[i],i);
       }
        Arrays.sort(ans);
        return ans;
    }
}
