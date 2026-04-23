class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];
         if(stones.length==2){
            if(stones[0]==stones[1]) return 0;
            else{
                return Math.abs(stones[0]-stones[1]);
            }
         }
       PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.reverseOrder());
       for(int i:stones){
        pq.add(i);
       }
       
       while(pq.size()>1){
            int q=pq.remove();
            int p=pq.remove();
            if(p!=q){
               pq.add(Math.abs(p-q));
            }
       }
       if(pq.isEmpty()) return 0;
       return pq.remove();
    }
}
