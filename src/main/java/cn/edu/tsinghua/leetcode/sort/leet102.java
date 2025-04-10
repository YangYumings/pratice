package cn.edu.tsinghua.leetcode.sort;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class leet102 {
  public static void main(String[] args) {
    // TODO String.ValueOf() 和 sout 会对float进行截断处理，不会显示float真实的值；

  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new LinkedList<>();


// 太麻烦了，空间上
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(0, root));
    while (!queue.isEmpty()) {
      List<Integer> currLevel = new LinkedList<>();
      Pair curr = queue.poll();
      if (curr.node.left != null) {
        queue.offer(new Pair(curr.level + 1, curr.node.left));
        currLevel.add(curr.node.left.val);
      }
      if (curr.node.right != null) {
        queue.offer(new Pair(curr.level + 1, curr.node.right));
      }


    }


    return null;
  }

  public class Pair {
    Integer level;
    TreeNode node;

    public Pair(Integer level, TreeNode node) {
      this.level = level;
      this.node = node;
    }
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
