class Solution {
    public List<List<Integer>> subsets(int[] nums) {
     Queue<List<Integer>> q = new LinkedList<>();
     List<Integer> lii = new ArrayList<>();
     List<List<Integer>> li = new ArrayList<>();
     q.add(new ArrayList<>());
     int idx = 0;
     while(idx < nums.length){
        int size = q.size();
        while(size-- > 0){
             List<Integer> m = q.remove();
             q.add(new ArrayList<>(m));
             List<Integer> temp = new ArrayList<>(m);
             temp.add(nums[idx]);
             q.add(temp);
        }
        idx++;
     }

     while(!q.isEmpty()){
        li.add(q.remove());
     } 

     return li;
    }
}
