package cn.edu.tsinghua.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class leet102 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 输入 int 数组转二叉树

  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null){
      return new ArrayList<>();
    }
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    // 每次都是每次的第一个结点开始
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new ArrayList<>();
      // 一次遍历一层
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        list.add(cur.val);
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
      res.add(list);
    }
    return res;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
