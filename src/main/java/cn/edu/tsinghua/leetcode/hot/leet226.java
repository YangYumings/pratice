package cn.edu.tsinghua.leetcode.hot;

public class leet226 {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        // 空时，返回空
        if (root == null) {
            return null;
        }
        // 递归左后子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
