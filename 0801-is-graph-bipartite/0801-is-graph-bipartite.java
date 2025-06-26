class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int [] colors = new int[n]; // array to visit color
        Arrays.fill(colors,-1); // initiallyy all -1
        for(int i=0; i<n; i++){ // for each node 
            if(colors[i] == -1){ // if not colored
                if(!bfs(i,graph,colors)) return false;
            }
        }
        return true;
    }
    public boolean bfs(int min, int [][] graph, int [] colors){
        Queue<Integer> q  = new LinkedList<>(); // queue
        colors[min] =  0; // color that node , start with 0
        q.add(min); // add to queue
        while(!q.isEmpty()){
            int node = q.poll(); // remove
            for(int adjnode : graph[node]){ // take that nodes all neighbour nodes
                if(colors[adjnode]  == -1){ // if neighbour not colored
                    colors[adjnode] = colors[node] == 1 ? 0:1;  // color adjnode oppo to color
                    // of parent node
                    q.add(adjnode); // add adjnode to queue
                } else if(colors[adjnode] == colors[node]){ // if both parent and neightbour 
                // neighbour node has same color then same on 2 adjacent node so not bipartite
                    return false;
                }
            }
        } 
            return true; 
        }
}
