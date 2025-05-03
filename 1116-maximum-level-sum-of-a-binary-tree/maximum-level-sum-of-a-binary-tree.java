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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> st = new LinkedList<>();
        int sum = root.val;
        st.add(root);
        int lvl =1,mainLevel = 1;
        while(!st.isEmpty()){
            int k = st.size();
            int ctr=0;
            for(int i = 0 ; i<k ; i++){
                TreeNode temp = st.poll();
                if(temp.left!=null) st.add(temp.left);
                if(temp.right!=null) st.add(temp.right);
                ctr+=temp.val;
            }
            if(ctr>sum){
                sum = ctr;
                mainLevel = lvl;
            }
            lvl++;
        }
        return mainLevel;
    }
}