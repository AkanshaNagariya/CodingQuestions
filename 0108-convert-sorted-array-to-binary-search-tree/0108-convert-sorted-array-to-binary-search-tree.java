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
    TreeNode root;
    public TreeNode sortedArrayToBST(int[] nums) {
         populatedSorted(nums, 0, nums.length);
         return root;
        }
    private void populatedSorted(int[] nums, int start, int end) {
	    if (start >= end) {
	      return;
	    }
	    int mid = (start + end) / 2;
	    this.insertit(nums[mid]);
	    populatedSorted(nums, start, mid);
	    populatedSorted(nums, mid + 1, end);
	  }
      public TreeNode insertit(int val) {
	    root = insert(val, root); // whatever ans will be returned fron this func 
	    // will be set as root for that perticular call
        return root;
	  }
      private TreeNode insert(int val, TreeNode node) {
	    if (node == null) { // if there is no value i.e this is root node itself 
	      node = new TreeNode(val);  // create it with value
	      return node;
	    }

	    if (val < node.val) { // else check if the value to insert is < our nodes's value 
	      node.left = insert(val, node.left); // insert at left of node 
	    }

	    if (val > node.val) { // insert at right
	      node.right = insert(val, node.right); // right of node
	    }
	    return node; // same node returned with left and right
	  }
}