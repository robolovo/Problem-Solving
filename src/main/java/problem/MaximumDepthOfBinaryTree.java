package problem;


/*
*   LeetCode - 104. Maximum Depth of Binary Tree (Easy)
*   https://leetcode.com/problems/maximum-depth-of-binary-tree/
*/
public class MaximumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 1);
    }

    private int dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        }

        int depthR = 0, depthL = 0;
        if (root.right != null) {
            depthR = dfs(root.right, depth + 1);
        }
        if (root.left != null) {
            depthL = dfs(root.left, depth + 1);
        }

        return Math.max(depthL, depthR);
    }
}
