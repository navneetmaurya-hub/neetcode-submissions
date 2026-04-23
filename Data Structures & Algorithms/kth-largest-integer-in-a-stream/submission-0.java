class KthLargest {
     PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.reverseOrder());
     int d=0;
    public KthLargest(int k, int[] nums) {
      d=k;
      for(int i:nums){
        pq.add(i);
      }  
    }
    
    public int add(int val) {
       pq.add(val);
       Queue<Integer>q=new LinkedList<>();
       for(int i=1;i<d;i++){
           q.add(pq.remove());
       }
       int ans=pq.remove();
       q.add(ans);
       while(!q.isEmpty()){
        pq.add(q.remove());
       }
       return ans;
    }
}
