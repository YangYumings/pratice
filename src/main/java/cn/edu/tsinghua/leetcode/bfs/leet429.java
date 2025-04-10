package cn.edu.tsinghua.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class leet429 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


  }

  public static List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<Node> queue = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        Node cur = queue.poll();
        list.add(cur.val);
        for (Node node : cur.children) {
          queue.offer(node);
        }
      }
      res.add(list);
    }

    return res;
  }

  public class Node {
    int val;
    List<Node> children;

    public Node(int val) {
      this.val = val;
    }

    public Node(int val, List<Node> children) {
      this.val = val;
      children = children;
    }
  }
}
