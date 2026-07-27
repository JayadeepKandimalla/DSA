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

            Integer[] arr= new Integer[n];
            for(int i= 0;i<n;i++){

                TreeNode curr= q.poll();
                int idx= i;

                if(level%2==0){
                    idx= n-i-1;
                }

                arr[idx]= curr.val;

                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            level++;
            ans.add(Arrays.asList(arr));
        }

        return ans;
    }
}