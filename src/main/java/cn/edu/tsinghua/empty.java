package cn.edu.tsinghua;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class empty {

  public static void main(String[] args) {

  }

  public static void dijkstra(int[][] grath, int start) {
    int numOfNode = grath.length;
    boolean[] vis = new boolean[numOfNode];
    int[] distance = new int[numOfNode];
    int[] path = new int[numOfNode];
    PriorityQueue<Node> queue = new PriorityQueue<>();

    Arrays.fill(distance, 0x3f3f3f3f);
    Arrays.fill(path, -1);

    // 第一个点
    distance[start] = 0;
    queue.offer(new Node(start, 0));

    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      int index = cur.index;
      if (vis[index]) {
        continue;
      }
      vis[index] = true;

      for (int i = 0; i < numOfNode; i++) {
        if (!vis[i]) {
          if (distance[index] + grath[index][i] < distance[i]) {
            distance[i] = distance[index] + grath[index][i];
            queue.offer(new Node(i, distance[i]));
            path[i] = index;
          }
        }
      }
    }
  }

  public int longestConsecutive(int[] nums) {
    int ans = 0;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    for (int num : set) {
      if (!set.contains(num - 1)) {
        int count = 1;
        while (set.contains(num + 1)) {
          count++;
          num++;
        }
        ans = Math.max(ans, count);
      }
    }
    return ans;
  }

  public static int minDepth(TreeNode root) {
    // 场景一 空
    if (root == null) {
      return 0;
    }
    // 场景二 叶子节点
    if (root.left == null && root.right == null) {
      return 1;
    }
    // 场景三 非叶子节点 循环递归
    int min_depth = Integer.MAX_VALUE;
    if (root.left != null) {
      min_depth = Math.min(min_depth, minDepth(root.left));
    }
    if (root.right != null) {
      min_depth = Math.min(min_depth, minDepth(root.right));
    }
    return min_depth + 1;
  }

  static class Node implements Comparable<Node> {
    int index;
    int cost;

    public Node(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
      return this.cost - other.cost;
    }
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

  static int N = 100010;
  static int[] headNodeList = new int[N];
  static int[] endPointOfEdge = new int[N];
  static int[] sibling = new int[N];
  static int[] color = new int[N];
  static int edgeNumber = 0;
  public static void add(int a, int b){
    endPointOfEdge[edgeNumber] = b;
    sibling[edgeNumber] = headNodeList[a];
    headNodeList[a] = edgeNumber++;
  }

  public static boolean dfs(int num, int newColor){
    color[num] = newColor;
    for(int i = headNodeList[num]; i != -1; i = sibling[i]){
      int target = endPointOfEdge[i];
      // 没有染色
      if(color[target] == 0){
        if(!dfs(target, 3 - newColor)){
          return false;
        }
      }else if(color[target] == newColor){
        return false;
      }
    }
    return true;
  }
}
