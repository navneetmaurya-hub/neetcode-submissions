class Solution {
    public static void subset(int[] nums,List<List<Integer>>li,List<Integer>lii,int j){
        if(j > nums.length - 1){
            li.add(new ArrayList<>(lii));
            return;
        }
        subset(nums,li,lii,j+1);
        lii.add(nums[j]);
        subset(nums,li,lii,j+1);
        lii.remove(lii.size()-1);  
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>li=new ArrayList<>();
        List<Integer>lii=new ArrayList<>();
        subset(nums,li,lii,0);
        return li;
    }
}
