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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
       
        if(root==null) return ans;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int level= 1;

        while(!q.isEmpty()){
            int n= q.size();
            List<Integer> lev= new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode temp= q.poll();
                lev.add(temp.val);
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }

            if(level%2==0){
                Collections.reverse(lev);
                ans.add(lev);
            }
            else{
                ans.add(lev);
            }
            level++;
        }
        return ans;
    }
}