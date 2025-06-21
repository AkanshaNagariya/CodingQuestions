class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      int inicolor  = image[sr][sc]; // intitial color
      int ans[][] = image; // make copy of origial
      int delrow[] = {-1,0,1,0}; // for updpwn and leftright row and col 
      int delcol[] = {0,1,0,-1};
      dfs(sr,sc,ans,image,color, delrow, delcol, inicolor); //dfs
      return ans; 
    }
    private void dfs(int row, int col, int [][] ans, int [][] image,
    int color, int [] delrow, int []delcol, int inicolor){
        ans[row][col] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4;i++){ // for updown leftright
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && image[nrow][ncol] == inicolor
            && ans[nrow][ncol] != color){ // that is we have to make it color
               dfs(nrow,ncol,ans,image,color, delrow, delcol, inicolor);
            }
        }
    }
}