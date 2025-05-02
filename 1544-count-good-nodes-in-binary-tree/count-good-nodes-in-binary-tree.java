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
    int ctr = 0;
    void good(TreeNode root,int maxi){
        if(root==null) return;
        good(root.left,Math.max(maxi,root.val));
        good(root.right,Math.max(maxi,root.val));
        if(root.val>=maxi) ctr++;
    }
    public int goodNodes(TreeNode root) {
        int maxi = root.val;
        good(root,maxi);
        return ctr;
    }
}