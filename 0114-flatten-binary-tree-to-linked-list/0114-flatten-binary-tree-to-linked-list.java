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
    public void flatten(TreeNode root) {
        if(root==null) return;
        ArrayList<TreeNode> al= new ArrayList<>();
        preorder(root, al);
        for(int i=0; i<al.size() -1; i++){
            TreeNode curr= al.get(i);
            TreeNode next= al.get(i+1);
            curr.left= null;
            curr.right= next;
        }
    }

    public void preorder(TreeNode root, ArrayList<TreeNode> al){
        if(root==null) return;
        al.add(root);
        preorder(root.left, al);
        preorder(root.right, al);
    }
}