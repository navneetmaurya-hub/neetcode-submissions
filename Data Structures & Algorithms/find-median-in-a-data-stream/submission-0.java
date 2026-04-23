class MedianFinder {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Queue<Integer> q = new LinkedList<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        pq.add(num);
    }
    
    public double findMedian() {
        int size = pq.size();
        if(size % 2 == 0){
            for(int i = 1; i <= size/2 - 1; i++){
                q.add(pq.remove());
            }
            int a = pq.remove();
            int b = pq.remove();
            q.add(a);
            q.add(b);
            while(!q.isEmpty()){
                pq.add(q.remove());
            }
            return ((double)a + (double)b) / 2;
        }
        else{
            for(int i = 1; i <= size/2; i++){
                q.add(pq.remove());
            }
            int ans = pq.remove();
            q.add(ans);
            while(!q.isEmpty()){
                pq.add(q.remove());
            }
            return (double) ans;
        }
    }
}
