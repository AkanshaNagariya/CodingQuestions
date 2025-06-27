class Solution {
/* in-degree:
number of edges going into a node
If there is no edges coming into a node its a start node and has to be part of the solution set
out-degree:
number of edges coming out of a node
In the question edges list format is [[out-degree, in-degree] , [out-degree, in-degree] . . .]]
e.g. [[0,1],[0,2],[2,5],[3,4],[4,2]]
Here, Outdegree is at 0th index and Indegree is at 1st index.
So we need to find which number is not in 1st index.
So the ans of above example is [0, 3] i.e. 0 and 3 is not in 1st index.*/ 
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for (List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}