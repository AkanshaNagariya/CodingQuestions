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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }
    public TreeNode insert(TreeNode node, int val){
        if(node == null){
            node = new TreeNode(val);
            return node;
        }
        if(val < node.val){
            node.left = insert(node.left, val);
        }
        if(val > node.val){
            node.right = insert(node.right, val);
        }
        return node;
    }
}