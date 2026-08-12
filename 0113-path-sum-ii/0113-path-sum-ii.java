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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res= new ArrayList<>();
        helper(root, targetSum,new ArrayList<>(), res);
        return res;
    }

    public void helper(TreeNode root, int tar, List<Integer> ans, List<List<Integer>> res){
        if(root==null){
            return;
        }

        if (root == null)
            return;

        ans.add(root.val);

        if (root.left == null && root.right == null && tar == root.val) {
            res.add(new ArrayList<>(ans));
            ans.remove(ans.size() - 1);
            return;
        }

        helper(root.left, tar - root.val, ans, res);
        helper(root.right, tar - root.val, ans, res);
        ans.remove(ans.size() - 1);
    }
}