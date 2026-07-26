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
    boolean flag= false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        preorder(root, targetSum, 0);
        return flag;
    }

    public void preorder(TreeNode curr, int tar, int sum){
        if(curr==null) 
            return;

        sum+= curr.val;
        if(curr.left==null && curr.right==null && sum== tar){
            flag= true;
            return;
        }

        preorder(curr.left, tar, sum);
        preorder(curr.right, tar, sum);
    }
}