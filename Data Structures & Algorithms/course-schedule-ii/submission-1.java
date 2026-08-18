class Solution {
    public static boolean iscycle(int i,List<List<Integer>> graph,boolean[] visited,boolean[] recursionstack) {
        visited[i] = true;
        recursionstack[i] = true;
        for (int j = 0; j < graph.get(i).size(); j++) {
            int neighbour = graph.get(i).get(j);
            if (!visited[neighbour]) {
                if (iscycle(neighbour, graph, visited, recursionstack)) {
                    return true;
                }
            } else if (recursionstack[neighbour]) {

                return true;
            }
        }
        recursionstack[i] = false;
        return false;
    }

    public static void topology(int i,List<List<Integer>> graph,boolean[] visited,Stack<Integer> st){
        visited[i] = true;
        for (int j = 0; j < graph.get(i).size(); j++) {
            int neighbour = graph.get(i).get(j);
            if (!visited[neighbour]) {
                topology(neighbour, graph, visited, st);
            }
        }
        st.push(i);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(prerequisite).add(course);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recursionstack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (iscycle(i, graph, visited, recursionstack)) {
                    return new int[0];
                }
            }
        }
        boolean[] visited1 = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited1[i]) {
                topology(i, graph, visited1, st);
            }
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while (!st.isEmpty()) {
            ans[idx] = st.pop();
            idx++;
        }
        return ans;
    }
}
