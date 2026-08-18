// class Solution {
//     public static void cycle(int i,List<List<Integer>> graph,int ans[],int par,boolean visited[]){
//       visited[i] = true;
//         for (int j = 0; j < graph.get(i).size(); j++) {
//             int neighbour = graph.get(i).get(j);
//             if (neighbour == par) {
//                 continue;
//             }
//             if (visited[neighbour]) {
//                 ans[0] = i;
//                 ans[1] = neighbour;
//                 return;
//             }
//             cycle(neighbour, graph, ans, i, visited);
//             if (ans[0] != -1) {
//                 return;
//             }
//         }
//     }

//     public static boolean dfs(int i,List<List<Integer>> graph,int target,HashSet<Integer> hs,boolean visit[]){
//       visit[i] = true;
//       hs.add(i);
//       if (i == target) {
//             return true;
//       }
//       for (int j = 0; j < graph.get(i).size(); j++) {
//             int neighbour = graph.get(i).get(j);
//             if (!visit[neighbour]) {
//                 if (dfs(neighbour, graph, target, hs, visit)) {
//                     return true;
//                 }
//             }
//         }
//         hs.remove(i);
//         visit[i] = false;
//         return false;
//     }

//     public int[] findRedundantConnection(int[][] edges) {
//       List<List<Integer>> graph = new ArrayList<>();
//         for (int i = 0; i <= edges.length; i++) {
//             graph.add(new ArrayList<>());
//         }
//         for (int i = 0; i < edges.length; i++) {
//             int u = edges[i][0];
//             int v = edges[i][1];
//             graph.get(u).add(v);
//             graph.get(v).add(u);
//         }
//         int ans[] = {-1, -1};
//         boolean visited[] = new boolean[edges.length + 1];
//         for (int i = 1; i <= edges.length; i++) {
//             if (!visited[i]) {
//                 cycle(i, graph, ans, -1, visited);
//                 if (ans[0] != -1) {
//                     break;
//                 }
//             }
//         }
//         HashSet<Integer> hs = new HashSet<>();
//         boolean visit[] = new boolean[edges.length + 1];
//         dfs(ans[0], graph, ans[1], hs, visit);
//         for (int i = edges.length - 1; i >= 0; i--) {
//             int u = edges[i][0];
//             int v = edges[i][1];
//             if (hs.contains(u) && hs.contains(v)) {
//                 return edges[i];
//             }
//         }
//         return ans;
//     }
// }

class Solution {

    // -----------------------------------------
    // Step 1: Detect any cycle edge
    // -----------------------------------------
    public static void cycle(
        int i,
        List<List<Integer>> graph,
        int ans[],
        int par,
        boolean visited[]
    ) {

        visited[i] = true;

        for (int j = 0; j < graph.get(i).size(); j++) {

            int neighbour = graph.get(i).get(j);

            if (neighbour == par) {
                continue;
            }

            if (visited[neighbour]) {

                ans[0] = i;
                ans[1] = neighbour;

                return;
            }

            cycle(neighbour, graph, ans, i, visited);

            // Cycle mil gayi
            if (ans[0] != -1) {
                return;
            }
        }
    }


    // -----------------------------------------
    // Step 2: Find path between cycle vertices
    // BUT detected cycle edge ko ignore karo
    // -----------------------------------------
    public static boolean dfs(
        int i,
        List<List<Integer>> graph,
        int target,
        int blockU,
        int blockV,
        HashSet<Integer> hs,
        boolean visit[]
    ) {

        visit[i] = true;
        hs.add(i);

        if (i == target) {
            return true;
        }

        for (int j = 0; j < graph.get(i).size(); j++) {

            int neighbour = graph.get(i).get(j);

            // Detected cycle edge ko ignore karo
            if ((i == blockU && neighbour == blockV) ||
                (i == blockV && neighbour == blockU)) {
                continue;
            }

            if (!visit[neighbour]) {

                if (dfs(
                    neighbour,
                    graph,
                    target,
                    blockU,
                    blockV,
                    hs,
                    visit
                )) {
                    return true;
                }
            }
        }

        // Backtracking
        hs.remove(i);
        visit[i] = false;

        return false;
    }


    public int[] findRedundantConnection(int[][] edges) {

        // -----------------------------------------
        // Graph create
        // -----------------------------------------

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= edges.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        // -----------------------------------------
        // Step 1: Detect cycle
        // -----------------------------------------

        int ans[] = {-1, -1};

        boolean visited[] =
            new boolean[edges.length + 1];

        for (int i = 1; i <= edges.length; i++) {

            if (!visited[i]) {

                cycle(
                    i,
                    graph,
                    ans,
                    -1,
                    visited
                );

                if (ans[0] != -1) {
                    break;
                }
            }
        }


        // -----------------------------------------
        // Step 2:
        // Detected edge ke bina cycle ka path
        // find karo
        // -----------------------------------------

        HashSet<Integer> hs = new HashSet<>();

        boolean visit[] =
            new boolean[edges.length + 1];

        dfs(
            ans[0],
            graph,
            ans[1],
            ans[0],
            ans[1],
            hs,
            visit
        );


        // -----------------------------------------
        // Step 3:
        // Original edges ko reverse me check karo
        // -----------------------------------------

        for (int i = edges.length - 1; i >= 0; i--) {

            int u = edges[i][0];
            int v = edges[i][1];

            if (hs.contains(u) && hs.contains(v)) {

                return edges[i];
            }
        }

        return ans;
    }
}