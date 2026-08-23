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
    TreeNode xparent= null;
    TreeNode yparent= null;
    int xlvl= -1;
    int ylvl= -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return xlvl== ylvl && xparent!=yparent;
    }

    public void dfs(TreeNode root, TreeNode parent, int level, int x, int y){
        if(root==null) return;

        if(root.val==x){
            xlvl= level;
            xparent = parent;
        }

        if(root.val==y){
            ylvl= level;
            yparent= parent;
        }

        dfs(root.left, root, level+1, x, y);
        dfs(root.right, root, level+1, x, y);
    }
}