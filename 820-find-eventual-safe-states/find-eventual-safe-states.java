class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
    List<List<Integer>> glist = new ArrayList<>();
    for (int i = 0; i < graph.length; i++) {
        glist.add(new ArrayList<>());
        for (int node : graph[i]) {
            glist.get(i).add(node);
        }
    }
    int v = glist.size();
    int vis [] = new int[v];
    int pathVis [] = new int[v];
    int check [] = new int[v];
    for(int i=0; i<v; i++){
        if(vis[i] == 0){
            dfsCheck(i,glist, vis, pathVis, check);
        }
    }
    List <Integer> safenode = new ArrayList<>();
    for(int i=0; i<v; i++){
        if(check[i]  == 1) safenode.add(i);
    }
    return safenode;
    }
    private boolean dfsCheck(int node, List<List<Integer>>adj, int vis[], int pathVis[], int check[]){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        // traverse for adjacent nodes
        for(int it: adj.get(node)){
            if(vis[it] == 0){
                if(dfsCheck(it,adj, vis, pathVis, check) == true)
                return true;
            }
            // if the node has been previously visited
            // but it has to be visited on same path
            else if(pathVis[it] == 1){
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}