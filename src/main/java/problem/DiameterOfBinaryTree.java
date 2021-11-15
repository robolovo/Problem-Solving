package problem;

/*
*   LeetCode - 543. Diameter of Binary Tree (Easy)
*   https://leetcode.com/problems/diameter-of-binary-tree/
*/
public class DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int maxLength;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxLength = 0;
        dfs(root);
        return maxLength;
    }

    private int dfs(TreeNode curr) {
        if (curr.left == null && curr.right == null) {
            return 1;
        }

        int lengthL = 0;
        if (curr.left != null){
            lengthL = dfs(curr.left) + 1;
        }

        int lengthR = 0;
        if (curr.right != null) {
            lengthR = dfs(curr.right) + 1;
        }

        maxLength = Math.max(maxLength, lengthL + lengthR);
        return Math.max(lengthL, lengthR);
    }
}
