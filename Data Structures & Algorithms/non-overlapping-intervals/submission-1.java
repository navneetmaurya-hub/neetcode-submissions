class Solution {
    static class Pair implements Comparable<Pair>{
        int a,b;
        public Pair(int c,int d){
            this.a=c;
            this.b=d;
        }
        public int compareTo(Pair p2){
            if(this.b==p2.b){
                return this.a-p2.a; // ascending start
            }
            return this.b-p2.b; // ascending end
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){
            q.add(new Pair(intervals[i][0],intervals[i][1]));
        }
        Pair w=q.remove();
        int m=w.b;
        int ans=0;
        while(!q.isEmpty()){
            Pair e=q.remove();
            if(e.a>=m){
                m=e.b;
            }
            else{
                ans++;
            }
        }

        return ans;
    }
}