class Solution {
    static class Pair{
        int a;
        int b;
        public Pair(int p,int q){
            this.a=p;
            this.b=q;
        }
    }
    static class Pair1 implements Comparable <Pair1>{
        int a;
        Pair z;
        public Pair1(int w,Pair e){
          this.a=w;
          this.z=e;  
        }
        public int compareTo(Pair1 p2){
            return this.a- p2.a;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
     int ans[][]=new int [k][2];
     PriorityQueue<Pair1>pq=new PriorityQueue<>();
     for(int i=0;i<points.length;i++){
         int an=(points[i][0]*points[i][0])+(points[i][1]*points[i][1]);
         pq.add(new Pair1(an,new Pair(points[i][0],points[i][1])));
     }
     for(int i=0;i<k;i++){
        Pair1 w=pq.remove();
        ans[i][0]=w.z.a;
        ans[i][1]=w.z.b;
     } 
     return ans;
    }
}
