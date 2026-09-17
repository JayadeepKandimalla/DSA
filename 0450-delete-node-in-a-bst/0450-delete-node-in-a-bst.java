class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        TreeNode parent = null;
        TreeNode curr = root;

        while (curr != null && curr.val != key) {
            parent = curr;

            if (key < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (curr == null) return root;

        TreeNode left = curr.left;
        TreeNode right = curr.right;

        if (right == null) {
            if (parent == null) {
                return left;      
            }

            if (parent.left == curr) {
                parent.left = left;
            } else {
                parent.right = left;
            }

            return root;
        }

        TreeNode res = reconstruct(left, right);

        if (parent == null) {
            return res;
        }

        if (parent.left == curr) {
            parent.left = res;
        } else {
            parent.right = res;
        }

        return root;
    }

    public TreeNode reconstruct(TreeNode left, TreeNode right) {

        TreeNode curr = right;

        while (curr.left != null) {
            curr = curr.left;
        }
        curr.left = left;

        return right;
    }
}