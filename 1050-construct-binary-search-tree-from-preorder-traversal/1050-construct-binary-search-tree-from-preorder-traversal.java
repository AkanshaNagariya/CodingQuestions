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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0){
            return null;
        }
        int r  = preorder[0];
        int index = preorder.length;
        for(int i=1; i<preorder.length; i++){
            if(preorder[i] > r){
                index = i;
                break;
            }
        }
        TreeNode node = new TreeNode(r);
        node.left = bstFromPreorder(Arrays.copyOfRange(preorder,1,index));
        node.right = bstFromPreorder(Arrays.copyOfRange(preorder,index,preorder.length));
        return node;
    }
}