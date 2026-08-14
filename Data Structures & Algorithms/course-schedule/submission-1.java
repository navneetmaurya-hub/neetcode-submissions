class Solution {
    public static boolean iscycle(int i,List<List<Integer>> graph,boolean visited[],boolean recursionstack[]) {
        visited[i] = true;
        recursionstack[i] = true;
        for(int j = 0; j < graph.get(i).size(); j++) {
            int neighbour = graph.get(i).get(j);
            if(!visited[neighbour]) {
                if(iscycle(neighbour, graph, visited, recursionstack)) {
                    return true;
                }
            } 
            else {
                if(recursionstack[neighbour]) {
                    return true;
                }
            }
        }
        recursionstack[i] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean visited[] = new boolean[numCourses];
        boolean recursionstack[] = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(iscycle(i, graph, visited, recursionstack)) {
                    return false;
                }
            }
        }
        return true;
    }
}