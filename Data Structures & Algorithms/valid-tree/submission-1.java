class Solution {
    public static boolean cycle(int curr, boolean visit[], List<List<Integer>> graph, int par) {
        visit[curr] = true;

        for(int i = 0; i < graph.get(curr).size(); i++) {
            int neighbour = graph.get(curr).get(i);

            if(visit[neighbour] && neighbour != par) {
                return true;
            }
            else if(!visit[neighbour]) {
                if(cycle(neighbour, visit, graph, curr)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        boolean visit[] = new boolean[n];
        if(cycle(0, visit, graph, -1)) {
            return false;
        }
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                return false;
            }
        }
        return true;
    }
}
