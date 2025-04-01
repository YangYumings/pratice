package cn.edu.tsinghua.acwing.bfs;

import java.util.Arrays;
import java.util.Scanner;

public class acwing860 {
  static int N = 100010;
  static int[] headNodeList = new int[N];
  static int[] endPointOfEdge = new int[N * 2];
  static int[] sibling = new int[N * 2];
  static int[] color = new int[N];
  static int edgeNumber = 0;
  static int n = 0, m = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    Arrays.fill(headNodeList, -1);
    // 初始化
    while (m-- != 0) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      add(a, b);
      add(b, a);
    }
//    Arrays.fill(color, -1);
    // 遍历所有节点（为染色），判断染色是否冲突
    for (int i = 1; i <= n; i++) {
      if (color[i] == 0) {
        if (!dfs(i, 1)) {
          System.out.println("No");
          return;
        }
      }
    }
    System.out.println("Yes");
  }

  public static void add(int a, int b) {
    endPointOfEdge[edgeNumber] = b;
    sibling[edgeNumber] = headNodeList[a];
    headNodeList[a] = edgeNumber++;
  }

  public static boolean dfs(int num, int newColor) {
    color[num] = newColor;
    for (int i = headNodeList[num]; i != -1; i = sibling[i]) {
      int target = endPointOfEdge[i];
      // 没有染色
      if (color[target] == 0) {
        if (!dfs(target, 3 - newColor)) {
          return false;
        }
      } else if (color[target] == newColor) {
        return false;
      }
    }
    return true;
  }
}

