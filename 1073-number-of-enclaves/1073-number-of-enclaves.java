class Solution {
    public int numEnclaves(int[][] grid) {
     int n = grid.length , m = grid[0].length;
        int delrow[] = {-1,0,1,0};
        int delcol[]  = {0,1,0,-1};
        int vis[][]= new int[n][m];
        int cnt = 0;
        // boundary traversal
        for(int j=0; j<m; j++){ // traverse first and last row
            if(vis[0][j] == 0 && grid[0][j] == 1){
                dfs(0, j, vis, grid, delrow, delcol);
            }
            if(vis[n-1][j] == 0 && grid[n-1][j] == 1){
                dfs(n-1, j, vis, grid, delrow, delcol);
            }
        }
        for(int i=0; i<n; i++){ // traverse first and last col
            if(vis[i][0] == 0 && grid[i][0] == 1){ // first col
                dfs(i, 0, vis, grid, delrow, delcol);
            }
            if(vis[i][m-1] == 0 && grid[i][m-1] == 1){ // last col
                dfs(i, m-1, vis, grid, delrow, delcol);
            }
        } // after dfs
        for(int i=0; i<n; i++){ // check all the matrix and wherever the visited is still 0
            for(int j=0; j<m; j++){ // means not visited and has O means can be converted to X
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void dfs(int row, int col, int [][]vis, int [][]grid, int []delrow, int [] delcol){
        vis[row][col] = 1; // visited
        int n = grid.length, m = grid[0].length;
        // check for top, right, bottom , up
        for(int i=0; i<4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol]== 0 && grid[nrow][ncol] == 1){
                dfs(nrow,ncol, vis,grid, delrow, delcol);
            }
        }
    }
}