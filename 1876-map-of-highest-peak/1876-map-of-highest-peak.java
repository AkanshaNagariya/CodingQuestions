     
 class Pair { // to store row ,col and dist in queue
    int row;
    int col;
    int dist;
    Pair(int _row, int _col , int _dist){
        this.row = _row;
        this.col = _col;
        this.dist = _dist;
    }
}
class Solution {
    // Function to find distance of nearest 1 in the grid for each cell.
   public int[][] highestPeak(int[][] isWater) { 
        // Code here
        int n = isWater.length;
        int m = isWater[0].length;
        int vis [][] = new int[n][m]; // visited array 
        int dist[][] = new int[n][m]; // resulatant dist array
        Queue<Pair> q  = new LinkedList<>();
        for(int i= 0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isWater[i][j] == 1){ // if you find nearest dist to 1 then keep 1 here
                // if 0 then keep 0 here
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }
        int delrow [] = {-1,0,1,0}; // updpwn leftright  
        int delcol [] = {0,+1, 0, -1};
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dis = q.peek().dist;
            q.remove();
            dist[row][col] = dis; // store dis in resultant arr
            for(int i=0; i<4; i++){  // check updown leftright
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < n &&  ncol >= 0 && ncol < m && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol,dis+1));
                }
            }
        }
            return dist;
    }
}