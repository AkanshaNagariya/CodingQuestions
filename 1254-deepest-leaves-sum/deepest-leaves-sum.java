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
    public int deepestLeavesSum(TreeNode root) {
       if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            sum = 0; // Reset sum for current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }

        return sum; // sum of deepest level
}
}