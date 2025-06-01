class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int row = m - k + 1;
        int col = n - k + 1;
         int[][] ans = new int[row][col];
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <col; j++) {
            TreeSet<Integer> st = new TreeSet<>();
                for (int x = i; x <i + k; x++) {
                    for (int y = j; y <j + k; y++) {
                     st.add(grid[x][y]);
                    }
                }
                if (st.size() == 1) {
                     ans[i][j] = 0;
                } else {
                    int mdiff = Integer.MAX_VALUE;
                    Integer lst = null;
                    for (int vl : st) {
                        if (lst != null) mdiff = Math.min(mdiff, vl - lst);
                        lst = vl;
                    }
                    ans[i][j] = mdiff;
                }
            }
        }
        return ans;
    }
}