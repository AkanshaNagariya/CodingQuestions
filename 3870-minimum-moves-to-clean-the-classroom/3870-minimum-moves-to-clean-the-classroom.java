class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++){
            arr[i] = classroom[i].toCharArray();
        }
        int sr = 0, sc = 0, lcnt = 0;
         Map<Integer, Integer> lIdx = new HashMap<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
            if (arr[i][j] == 'S'){
                sr = i; sc = j; 
            }
            else if (arr[i][j] == 'L'){
                lIdx.put(i * n + j, lcnt++);
            }
        }
        }
        int fmsk = (1 << lcnt) - 1;
        boolean[][][][] see = new boolean[m][n][energy + 1][1 << lcnt];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc, energy, 0, 0});
        see[sr][sc][energy][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], e = cur[2], mask = cur[3], dist = cur[4];
            if (mask == fmsk) {
                return dist;
            }
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                char cell = arr[nr][nc];
                if (cell == 'X') continue;
                int ne = e - 1;
                if (ne < 0) continue;
                if (cell == 'R') ne = energy;
                int nmask = mask;
                if (cell == 'L') nmask |= 1 << lIdx.get(nr * n + nc);
                if (!see[nr][nc][ne][nmask]) {
                    see[nr][nc][ne][nmask] = true;
                    q.offer(new int[]{nr, nc, ne, nmask, dist + 1});
                }
            }
        }
        return -1;
    }
}