class Solution {
    public static void dfs(int curr,List<List<Integer>>graph,boolean visit[]){
        if(visit[curr]==true) return;
        visit[curr]=true;
        for(int i=0;i<graph.get(curr).size();i++){
            int d=graph.get(curr).get(i);
            if(visit[d]==false) dfs(d,graph,visit);
        }
    }
    public int countComponents(int n, int[][] edges) {
      List<List<Integer>>graph=new LinkedList<>();
      for(int i=0;i<n;i++){
        graph.add(new ArrayList<>());
      }
      for(int i=0;i<edges.length;i++){
        int a=edges[i][0];
        int b=edges[i][1];
        graph.get(a).add(b);
        graph.get(b).add(a);
      }
      boolean visit[]=new boolean[n];
      int ans=0;
      for(int i=0;i<visit.length;i++){
        if(visit[i]==false){
            dfs(i,graph,visit);
            ans++;
        }
      }
      return ans;
    }
}
