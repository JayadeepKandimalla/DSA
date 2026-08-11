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
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;
    }

    public int helper(TreeNode root){
        if(root==null) return 0;
        int ls= helper(root.left);
        int rs= helper(root.right);

        if(ls==-1 || rs==-1) return -1;
        if(Math.abs(ls-rs)>1) return -1;
        return Math.max(ls, rs) +1;
    }
}