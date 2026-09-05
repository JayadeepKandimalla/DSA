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
    int c=0, res= 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        inorder(root,k);
        return res;
    }

    public void inorder(TreeNode root, int k){
        if(root==null) return;

        inorder(root.left, k);
        c++;
        if(c==k) res= root.val;
        inorder(root.right, k);
    }
}