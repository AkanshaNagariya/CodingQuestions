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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null || root.left == null || root.right == null){
            return root;
        }
        leveltraverse(root.left, root.right, 0);
        return root;
    }
    public void leveltraverse(TreeNode node1, TreeNode node2, int level){
        if(node1 == null || node2 == null){
            return;
        }
        if(level % 2 == 0){
            int val = node1.val;
            node1.val = node2.val;
            node2.val = val;
        }
        leveltraverse(node1.left, node2.right, level+1);
        leveltraverse(node1.right, node2.left, level+1);
    }
}