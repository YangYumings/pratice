package cn.edu.tsinghua.leetcode.dfs;


public class leet1223 {
  public static void main(String[] args) {

  }

  public static Pair<leet111.TreeNode, Integer> f(leet111.TreeNode root) {
    if (root == null) {
      return new Pair<>(root, 0);
    }
    Pair<leet111.TreeNode, Integer> left = f(root.left);
    Pair<leet111.TreeNode, Integer> right = f(root.right);
    if (left.second > right.second) {
      return new Pair<>(left.first, left.second + 1);
    }
    if (left.second < right.second) {
      return new Pair<>(right.first, right.second + 1);
    }
    return new Pair<>(root, left.second + 1);
  }

  static class Pair<T, U> {
    T first;
    U second;

    public Pair(T first, U second) {
      this.first = first;
      this.second = second;
    }
  }
}
