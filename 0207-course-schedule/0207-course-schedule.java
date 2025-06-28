class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); // directed edge u -> v
        }

        // Step 2: Topo sort using BFS 
        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int it: adj.get(i)) {
                indegree[it]++;
            }
        }
            Queue<Integer> q = new LinkedList<Integer>();
            for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        // Step 3: Prepare result
     int ans = 0;
        
       while(!q.isEmpty()){
           int node = q.peek();
           q.remove();
           ans++;
           for(int it : adj.get(node)){
               indegree[it]--;
               if(indegree[it] == 0){
                   q.add(it);
               }
           }
       }
       return ans == numCourses;

    }
}
