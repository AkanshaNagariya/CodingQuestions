class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    dfs(i, j, vis, grid, delrow, delcol);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void dfs(int row, int col, int[][] vis, char[][] grid, int[] delrow, int[] delcol) {
        vis[row][col] = 1;
        int n = grid.length, m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                dfs(nrow, ncol, vis, grid, delrow, delcol);
            }
        }
    }
}
