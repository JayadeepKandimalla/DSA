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
import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);

        nodes.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for (int[] node : nodes) {
            int col = node[0], val = node[2];
            if (col != prevCol) {
                res.add(new ArrayList<>());
                prevCol = col;
            }
            res.get(res.size() - 1).add(val);
        }

        return res;
    }

    private void dfs(TreeNode node, int col, int row, List<int[]> nodes) {
        if (node == null) return;
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, col - 1, row + 1, nodes);
        dfs(node.right, col + 1, row + 1, nodes);
    }
}