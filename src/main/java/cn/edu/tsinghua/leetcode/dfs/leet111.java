package cn.edu.tsinghua.leetcode.dfs;

import cn.edu.tsinghua.empty;

public class leet111 {
  public static void main(String[] args) {

  }

  public static int minDepth(TreeNode root) {
    // 场景一 空
    if (root == null) {
      return 0;
    }
    // 场景二 叶子节点
    if (root.left != null && root.right == null) {
      return 1;
    }
    // 场景三 非叶子节点 循环递归
    int min = Integer.MAX_VALUE;
    if (root.left != null) {
      min = Math.min(min, minDepth(root.left));
    }
    if (root.right != null) {
      min = Math.min(min, minDepth(root.right));
    }
    // 算上此时的 root 节点
    return min + 1;
  }

  static class TreeNode {
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
