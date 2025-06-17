/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void makeParent(TreeNode root, Map<TreeNode, TreeNode> parent_trc , TreeNode target){
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        while(!Q.isEmpty()){
            TreeNode curr = Q.poll();
            if(curr.left != null){
                parent_trc.put(curr.left, curr);
                Q.offer(curr.left);
            }
           if(curr.right != null){
                parent_trc.put(curr.right, curr);
                Q.offer(curr.right);
            } 
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       Map<TreeNode , TreeNode> parent_trc = new HashMap<>();
       makeParent(root, parent_trc, null);
       Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (curr_level == k) {
                break;
            }
            curr_level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && visited.get(node.left) == null) {
                    q.offer(node.left);
                    visited.put(node.left, true);
                }
                if (node.right != null && visited.get(node.right) == null) {
                    q.offer(node.right);
                    visited.put(node.right, true);
                }
                if(parent_trc.get(node) != null && visited.get(parent_trc.get(node)) == null){
                    q.offer(parent_trc.get(node));
                    visited.put(parent_trc.get(node), true);
                }
            }
        }
         List<Integer> result= new ArrayList<>();
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
        return result;
    }
}