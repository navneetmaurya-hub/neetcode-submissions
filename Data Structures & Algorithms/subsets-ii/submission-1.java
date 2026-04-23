class Solution {
    public static void dfs(int[] nums,HashSet<List<Integer>>hs,List<Integer>lii,int j){
        if(j>nums.length-1){
            // Collections.sort(lii);
            if(!hs.contains(lii)) hs.add(new ArrayList<>(lii));
            return;
        }
        dfs(nums,hs,lii,j+1);
        lii.add(nums[j]);
        dfs(nums,hs,lii,j+1);
        lii.remove(lii.size()-1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
    List<List<Integer>>li=new ArrayList<>();
    HashSet<List<Integer>>hs=new HashSet<>();
    List<Integer>lii=new ArrayList<>();
    dfs(nums,hs,lii,0);
    int z=0;
    for(List<Integer>m:hs){
        li.add(new ArrayList<>(m));
    }
    return li;
    }
}
