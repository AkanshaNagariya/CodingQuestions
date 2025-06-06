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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
           if(root == null) {
            return res;
           }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelsize = q.size();
            List<Integer> ans = new ArrayList<>();
            for(int i=0; i<levelsize;i++){
                TreeNode currnode = q.poll();
                ans.add(currnode.val);
                if(currnode.left != null){
                    q.offer(currnode.left);
                }
                if(currnode.right != null){
                    q.offer(currnode.right);
                }
            }
            res.add(ans);
        }
        return res;
    }
}