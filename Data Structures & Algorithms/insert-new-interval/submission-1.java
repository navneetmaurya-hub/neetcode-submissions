class Solution {
    static class Pair{
        int a,b;
        public Pair(int c,int d){
            this.a=c;
            this.b=d;
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
      int a[]=new int[1005];
      Queue<Pair>pq=new LinkedList<>();
      for(int i=0;i<intervals.length;i++){
        for(int j=intervals[i][0]; j<intervals[i][1];j++){
            a[j]++;
        }
      }
      if(newInterval[0]==newInterval[1]){
        pq.add(new Pair(newInterval[0],newInterval[1]));
      }
      for(int i=newInterval[0]; i<newInterval[1];i++){
        a[i]++;
      } 
      int z=-1;
      while(z<a.length-1){
          z++;
          
          if(a[z]>0){
            int p=z;
            while(a[z]!=0){
                z++;
            }
            pq.add(new Pair(p,z));
          }
      }
      int ans[][]=new int[pq.size()][2];
      int idx=0;
      while(!pq.isEmpty()){
        Pair w=pq.remove();
        ans[idx][0]=w.a;
        ans[idx][1]=w.b;
        idx++;
      }
      return ans;
    }
}
