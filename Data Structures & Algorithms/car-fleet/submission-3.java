class Solution {
    static class Pair implements Comparable<Pair>{
        int a;
        double b;
        public Pair(int p,double q){
            this.a=p;
            this.b=q;
        }
        public int compareTo(Pair p2){
            return p2.a-this.a; 
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
       PriorityQueue<Pair>pq=new PriorityQueue<>();
       for(int i=0;i<position.length;i++){
           pq.add(new Pair(position[i],(double)(target-position[i])/speed[i]));
       }
       int ans=0;
       Pair w=pq.remove();
       Pair e=new Pair(0,0);
       while(!pq.isEmpty()){
           e=pq.remove();
           if(w.b>=e.b){
 
           }
           else if(w.b<e.b){
            ans++;
            w=e;
           }
       }
       return ans+1;
    }
}
