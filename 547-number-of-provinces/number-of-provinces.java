class Solution {
    public int findCircleNum(int[][] isConnected) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    // we are given matrix so making it into adjacent list of list
         int V = isConnected.length; // no of nodes
         for(int i = 0;i<V;i++) { // 0 based indexing , create lists inside list
            adj.add(new ArrayList<Integer>()); 
        }
        for(int i=0; i<V; i++){
            for(int j = 0; j<V; j++){
                 if(isConnected[i][j] == 1 && i != j) {  // i.e for 1-2 
                    adj.get(i).add(j); // put 1 
                    adj.get(j).add(i);  // put 1
                }
            }
        }
        int vis [] = new int[V]; // visited array 
        int cnt = 0; // provinces
        for(int i=0; i<V;i++){
            if(vis[i] == 0){ // not visisted
                cnt++; // increse province 
                dfs(i, adj, vis); // do dfs traversal for it
            }
        }
        return cnt;
    }
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis []){
        vis[node] = 1;
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
              dfs(it, adj, vis);
            }
        }
    }
}