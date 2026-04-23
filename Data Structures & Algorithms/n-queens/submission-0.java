class Solution {
    public static boolean check(char grid[][], int i, int j, int n) {
        for (int k = 0; k < i; k++) {
            if (grid[k][j] == 'Q') return false;
        }
        int r = i - 1, c = j - 1;
        while (r >= 0 && c >= 0) {
            if (grid[r][c] == 'Q') return false;
            r--; c--;
        }
        r = i - 1; c = j + 1;
        while (r >= 0 && c < n) {
            if (grid[r][c] == 'Q') return false;
            r--; c++;
        }

        return true;
    }

    public static void dfs(char grid[][], int i, int n, List<List<String>> li) {

        if (i == n) {
            List<String> temp = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                temp.add(new String(grid[k]));
            }
            li.add(new ArrayList<>(temp));
            return;
        }

        for (int j = 0; j < n; j++) {

            if (check(grid, i, j, n)) {

                grid[i][j] = 'Q';

                dfs(grid, i + 1, n, li);

                grid[i][j] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        char grid[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }

        List<List<String>> li = new ArrayList<>();

        dfs(grid, 0, n, li);

        return li;
    }
}