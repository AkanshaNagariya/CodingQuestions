import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int col = 0;
        Queue<Tuple> queue = new ArrayDeque<>();
        Map<Integer, ArrayList<Pair>> map = new HashMap<>();

        queue.offer(new Tuple(root, col, 0));
        int min = 0, max = 0;

        while (!queue.isEmpty()) {
            Tuple removed = queue.poll();
            root = removed.node;
            col = removed.col;
            int row = removed.row;

            if (root != null) {
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<>());
                }
                map.get(col).add(new Pair(row, root.val));
                min = Math.min(min, col);
                max = Math.max(max, col);

                queue.offer(new Tuple(root.left, col - 1, row + 1));
                queue.offer(new Tuple(root.right, col + 1, row + 1));
            }
        }
        for (int i = min; i <= max; i++) {
            List<Pair> pairs = map.get(i);
            Collections.sort(pairs, (a, b) -> {
                if (a.row != b.row) return Integer.compare(a.row, b.row);
                return Integer.compare(a.val, b.val);
            });
            List<Integer> temp = new ArrayList<>();
            for (Pair p : pairs) {
                temp.add(p.val);
            }
            ans.add(temp);
        }
        return ans;
    }
}

class Tuple {
    TreeNode node;
    int col;
    int row;
    Tuple(TreeNode node, int col, int row) {
        this.node = node;
        this.col = col;
        this.row = row;
    }
}

class Pair {
    int row;
    int val;
    Pair(int row, int val) {
        this.row = row;
        this.val = val;
    }
}

