package cn.edu.tsinghua.leetcode.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class leet1631 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    sc.next();
  }

  public int minimumEffortPath(int[][] heights) {
    int m = heights.length;
    int n = heights[0].length;

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    int[] dis = new int[m * n];
    boolean[] vis = new boolean[m * n];
    Arrays.fill(dis, Integer.MAX_VALUE);
    dis[0] = 0;

    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

    queue.offer(new int[]{0, 0, 0});
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int x = cur[0];
      int y = cur[1];
      int d = cur[2];
      int index = x * n + y;
      if (vis[index]) {
        continue;
      }
      if (x == m - 1 && y == n - 1) {
        break;
      }
      vis[index] = true;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx * n + ny]) {
          // 然而本题中对于「最短路径」的定义不是其经过的所有边权的和，而是其经过的所有边权的最大值
          if (Math.max(d, Math.abs(heights[nx][ny] - heights[x][y])) < dis[nx * n + ny]) {
            dis[nx * n + ny] = Math.max(d, Math.abs(heights[nx][ny] - heights[x][y]));
            queue.offer(new int[]{nx, ny, dis[nx * n + ny]});
          }
        }
      }
    }
    return dis[m * n - 1];
  }


}
