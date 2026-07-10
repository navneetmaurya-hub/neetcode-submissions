class Solution {
    static class Pair {
        int a, b;

        public Pair(int c, int d) {
            this.a = c;
            this.b = d;
        }
    }

    public static boolean check(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return false;
        }
        return true;
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int ans = -1;
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;
        if (q.isEmpty()) return -1;

        while (!q.isEmpty()) {
            int size = q.size();
            ans++;

            while (size-- > 0) {
                Pair w = q.remove();
                int i = w.a;
                int j = w.b;

                if (check(i + 1, j, grid)) {
                    grid[i + 1][j] = 2;
                    q.add(new Pair(i + 1, j));
                }

                if (check(i - 1, j, grid)) {
                    grid[i - 1][j] = 2;
                    q.add(new Pair(i - 1, j));
                }

                if (check(i, j + 1, grid)) {
                    grid[i][j + 1] = 2;
                    q.add(new Pair(i, j + 1));
                }

                if (check(i, j - 1, grid)) {
                    grid[i][j - 1] = 2;
                    q.add(new Pair(i, j - 1));
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}
