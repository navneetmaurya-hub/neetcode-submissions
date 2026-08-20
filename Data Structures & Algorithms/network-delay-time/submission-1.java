class Solution {
    static class Pair{
        int a,b;
        public Pair(int d,int e){
            this.a=d;
            this.b=e;
        }
    }

    public static void dfs(int curr,List<List<Pair>> graph,int dist[],boolean visit[],int time){

        if(time >= dist[curr]){
            return;
        }

        dist[curr] = time;

        for(int i=0;i<graph.get(curr).size();i++){

            Pair neighbour = graph.get(curr).get(i);

            dfs(neighbour.a,graph,dist,visit,time+neighbour.b);
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            graph.get(times[i][0]).add(
                new Pair(times[i][1],times[i][2])
            );
        }

        int dist[] = new int[n+1];

        for(int i=1;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        boolean visit[] = new boolean[n+1];

        dfs(k,graph,dist,visit,0);

        int ans = 0;

        for(int i=1;i<=n;i++){

            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }

            ans = Math.max(ans,dist[i]);
        }

        return ans;
    }
}