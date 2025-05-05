class Solution {
    private int globIdx = 0;
    private int lastLevel = 0;
    private String t;
    
    public TreeNode recoverFromPreorder(String traversal) {
        t = traversal;
        TreeNode root = new TreeNode(extract());
        lastLevel = extract();
        solve(root, 1);
        return root;
    }
    
    private void solve(TreeNode node, int level) {
        if (level == lastLevel) {
            if (node.left == null) {
                node.left = new TreeNode(extract());
                lastLevel = extract();
                solve(node.left, level + 1);
            }
            if (level > lastLevel) {
                return;
            }
            if (node.right == null) {
                node.right = new TreeNode(extract());
                lastLevel = extract();
                solve(node.right, level + 1);
            }
        }
    }
    
    private int extract() {
        if (globIdx >= t.length()) {
            return -1;
        }
        
        if (t.charAt(globIdx) == '-') {
            int count = 0;
            while (globIdx < t.length() && t.charAt(globIdx) == '-') {
                count++;
                globIdx++;
            }
            return count;
        }
        
        int start = globIdx;
        while (globIdx < t.length() && t.charAt(globIdx) != '-') {
            globIdx++;
        }
        return Integer.parseInt(t.substring(start, globIdx));
    }
}

