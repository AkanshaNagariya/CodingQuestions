/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root.left);
        Q.add(root.right);
        while(!Q.isEmpty()){
            TreeNode left = Q.poll();
            TreeNode right = Q.poll();
            if(left == null && right == null){
               continue;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
            Q.add(left.left);
            Q.add(right.right);
            Q.add(left.right);
            Q.add(right.left);
        }
        return true;
    }
}