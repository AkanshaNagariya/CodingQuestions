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
    public List<Integer> postorderTraversal(TreeNode root) {
         LinkedList <Integer> res = new LinkedList<>();
           postorder(root, res);
           return res;               
    }
    public static void postorder(TreeNode root ,  LinkedList <Integer> res ){
        if(root == null){
            return;
        }
        postorder(root.left , res);
        postorder(root.right , res);
        res.add(root.val);
    }
}