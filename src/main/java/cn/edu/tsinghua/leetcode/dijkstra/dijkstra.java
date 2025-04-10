package cn.edu.tsinghua.leetcode.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 只能输出最短路径！！！还要优化
public class dijkstra {
  static int[] distance;
  static int[] path;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] graph = {
        {0,7,0,0,0,0,2,0},
        {7,0,6,0,0,0,0,3},
        {0,6,0,8,0,0,0,0},
        {0,0,8,0,3,0,0,0},
        {0,0,0,3,0,4,0,0},
        {0,0,0,0,4,0,2,0},
        {2,0,0,0,0,2,0,5},
        {0,3,0,0,0,0,5,0}
    };
    dijkstra(graph, 0);
    for (int i = 0; i < graph.length; i++) {
      System.out.println(i + ": " + distance[i]);
    }
    int p = path[6];
    StringBuilder sb = new StringBuilder();
    sb.append(p);
    while(p != 0){
      sb.append("->").append(path[p]);
      p = path[p];
    }
    System.out.println(sb.toString());
  }

  public static void dijkstra(int[][] grath, int start) {
    int numOfNode = grath.length;
    distance = new int[numOfNode]; // start 到 i 的当前最短路径；
    boolean[] vis = new boolean[numOfNode]; // 是否在最短路径中
    PriorityQueue<Node> queue = new PriorityQueue<>(); // 保证每次 poll 权最小的点
    path = new int[numOfNode]; // 记录此处找到的最小路径点的上一个点；

    Arrays.fill(distance, 0x3f3f3f3f);
    Arrays.fill(path, -1);

    distance[start] = 0;
    queue.offer(new Node(start, 0));
    path[start] = start;

    while (!queue.isEmpty()) {
      Node cur = queue.poll();
      int index = cur.num;
      if (vis[index]) {
        continue;
      }
      vis[index] = true;
      // 扫邻接矩阵
      for (int v = 0; v < numOfNode; v++) {
        if(!vis[v] && grath[index][v] > 0){
          if (distance[index] + grath[index][v] < distance[v]) {
            distance[v] = distance[index] + grath[index][v];
            queue.offer(new Node(v, distance[v]));
            path[v] = index;
          }
        }
      }
    }
  }

  static public class Node implements Comparable<Node> {
    int num;
    int weight;

    Node(int num, int weight) {
      this.num = num;
      this.weight = weight;
    }

    // 按 weight 升序排序
    @Override
    public int compareTo(Node other) {
      return this.weight - other.weight;
    }
  }
}
