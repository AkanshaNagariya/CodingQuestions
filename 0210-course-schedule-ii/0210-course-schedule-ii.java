import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Edge direction: prerequisite → course
        for (int[] edge : prerequisites) {
            int u = edge[1]; // prerequisite
            int v = edge[0]; // course
            adj.get(u).add(v); // u -> v
        }

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        if (topo.size() == V) {
            // convert List<Integer> to int[]
            int[] order = new int[V];
            for (int i = 0; i < V; i++) {
                order[i] = topo.get(i);
            }
            return order;
        } else {
            // cycle exists — not possible to finish all courses
            return new int[0];
        }
    }
}
