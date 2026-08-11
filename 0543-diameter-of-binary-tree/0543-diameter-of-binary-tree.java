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
    int globalMax= 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return globalMax;
    }

    public int helper(TreeNode root){
        if(root== null) return 0;
        int ls= helper(root.left);
        int rs= helper(root.right);

        globalMax= Math.max(globalMax, ls+rs);
        return Math.max(ls, rs) +1;
    }
}