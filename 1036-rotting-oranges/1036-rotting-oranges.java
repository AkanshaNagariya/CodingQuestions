class Pair{  // created class pair to store row , col and time
    int row;
    int col;
    int tm;
    Pair(int _row, int _col, int _tm){
        this.row = _row; this.col = _col; this.tm = _tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       Queue<Pair> q = new LinkedList<>(); // queue will have row , col and time
       int [][] vis = new int[n][m]; // visisted 2d array
       int cntfresh = 0; // fresh oranges
       for(int i=0; i<n;i++){
        for(int j = 0; j<m; j++){
            if(grid[i][j] == 2){ // rotten orange
                q.add(new Pair(i,j,0)); // add in queue
                vis[i][j] = 2; //mark visisted
            } else {
                vis[i][j] = 0;  // empty cell
            }
            if(grid[i][j] == 1) cntfresh++;
        }
       } 
       int tm = 0;   // to cnt max time to rotten all 
       int drow[] = {-1,0,+1,0}; // left right up down of row
       int dcol[] = {0,1,0,-1}; // of col
       int cnt = 0;  // the orange we rot now
       while(!q.isEmpty()){
        int r = q.peek().row;  // get row , col and t from queue
        int c = q.peek().col;
        int t = q.peek().tm;
        tm = Math.max(t,tm); // keep updating max time to rot
        q.remove(); // an element from queue and
        for(int i=0; i<4;i++){ // get leftright updown row and col
            int nrow = r + drow[i];  
            int ncol = c + dcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol <m && vis[nrow][ncol]==0
            && grid[nrow][ncol] == 1){  // the orange is fresh i.e 1 and not visisted
                q.add(new Pair(nrow, ncol, t+1)); // add in queue
                vis[nrow][ncol] = 2;  // mark visisted
                cnt++; // no of rotten
            }
        }
       }
       if(cnt != cntfresh) return -1;  // if we didn't rotten all oranges return -1
       return tm;
    }
}