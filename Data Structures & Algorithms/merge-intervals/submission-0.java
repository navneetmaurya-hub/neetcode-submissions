class Solution {
    static class Pair implements Comparable<Pair>{
        int a,b;
        public Pair(int c,int d){
            this.a=c;
            this.b=d;
        }
        public int compareTo(Pair p2){
            if(this.a==p2.a){
                return this.b-p2.b; // ascending end
            }
            return this.a-p2.a; // ascending start
        }
    }

    public int[][] merge(int[][] intervals) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        PriorityQueue<Pair> ans = new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){
            q.add(new Pair(intervals[i][0],intervals[i][1]));
        }
        Pair w=q.remove();
        int m=w.a;
        int n=w.b;
        while(!q.isEmpty()){
            Pair e=q.remove();
            if(e.a<=n){
                n=Math.max(n,e.b);
            }
            else{
                ans.add(new Pair(m,n));
                m=e.a;
                n=e.b;
            }
        }
        ans.add(new Pair(m,n));
        int ans1[][]=new int[ans.size()][2];
        for(int i=0;i<ans1.length;i++){
            Pair z=ans.remove();
            ans1[i][0]=z.a;
            ans1[i][1]=z.b;
        }
        return ans1;
    }
}
