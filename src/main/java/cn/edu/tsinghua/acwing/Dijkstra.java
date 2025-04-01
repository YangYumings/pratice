package cn.edu.tsinghua.acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
  static Integer n, m;
  // 存储边的长度
  static Integer[][] g = new Integer[1005][1005];
  // 此点是否找到最短路径，相当于集合T的作用
  static boolean[] status = new boolean[1005];
  // 最短路径数组
  static Integer[] dist = new Integer[1005];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      // 因为后续进行加发操作，使用Integer.MAXVALUE 会溢出
      Arrays.fill(g[i], 0x3f3f3f3f);
    }
    while (m-- > 0) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      g[a][b] = Math.min(g[a][b], c);
    }
    Arrays.fill(dist, 0x3f3f3f3f);
    dijkstra(1);
    if (dist[n] == 0x3f3f3f3f) {
      System.out.println("-1");
    } else {
      System.out.println(dist[n]);
    }
  }

  public static void dijkstra(int start) {
    // 初始点的距离为0
    dist[start] = 0;
    // 遍历每个点
    for (int i = 0; i < n; i++) {
      // 用于表示当前最短距离的点，-1代表第一个点
      int t = -1;
      // 找到dis中距离最小的点
      for (int j = 1; j <= n; j++) {
        // 未找到最短距离的点
        if (!status[j] && (t == -1 || dist[j] < dist[t])) {
          t = j;
        }
      }
      status[t] = true;
      // 更新距离
      for (int k = 1; k <= n; k++) {
        dist[k] = Math.min(dist[k], dist[t] + g[t][k]);
      }
    }
  }
}
