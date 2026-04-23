class Solution {
   public static void permutation(int[] nums,List<List<Integer>>li,List<Integer>lii,boolean visited[]){
      if(lii.size() == nums.length){
         li.add(new ArrayList<>(lii));
         return;
      }
      for(int i=0;i<nums.length;i++){
          if(!visited[i]){
            visited[i]=true;
            lii.add(nums[i]);
             permutation(nums,li,lii,visited);
             visited[i]=false;
             lii.remove(lii.size()-1);
          }
      }
   } 
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>>li=new ArrayList<>();
      List<Integer>lii=new ArrayList<>();
      boolean visited[]=new boolean[nums.length ];
      permutation(nums,li,lii,visited); 
      return li;
    }
}
