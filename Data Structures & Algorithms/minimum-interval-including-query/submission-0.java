class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
       HashMap<Integer,Integer>map=new HashMap<>();
       for(int i=0;i<intervals.length;i++){
          int d=(Math.abs(intervals[i][1]-intervals[i][0]))+1;
          for(int j=intervals[i][0]; j<=intervals[i][1];j++){
            if(map.containsKey(j)){
                if(d<map.get(j)){
                    map.put(j,d);
                }
            }
            else{
                map.put(j,d);
            }
          }
       }
       int ans[]=new int[queries.length];
       for(int i=0;i<queries.length;i++){
          if(map.containsKey(queries[i])){
            ans[i]=map.get(queries[i]);
          }
          else{
            ans[i]=-1;
          }
       }
       return ans;
    }
}
