package cn.edu.tsinghua.acwing.bfs;

import java.util.Arrays;
import java.util.Scanner;

public class acwing843 {
  static int N = 10;
  static int n;
  static char[][] map = new char[N][N];
  static boolean[] col = new boolean[N]; // 行
  /**
   * 在一个 N x N 的棋盘上，\ 方向的对角线从左上到右下。
   * 每条对角线可以用 (行号 + 列号) 唯一标识。
   * 最小的对角线标识是 0（第 0 行 + 第 0 列），最大的对角线标识是 2 * N - 2（第 N-1 行 + 第 N-1 列）。
   * 因此，共有 2 * N - 1 条对角线
   *
   * 在对角线上，(xi + yi) - (xi - yi) = {0,2,4,8,16...}
   *  (xi - yi) = 一个固定值，不同对角线不同，即查看 [x - y + n] , +n保证非负数
   * 在反对角线上，（xi + yi）是一个固定值，不同对角线不同，即查看 [x + y]
   */
  static boolean[] diagonal = new boolean[2 * N]; // 对角线
  static boolean[] backDiagonal = new boolean[2 * N];  // 反对角线

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = '.';
      }
    }
//    Arrays.fill(col, false);
//    Arrays.fill(diagonal, false);
//    Arrays.fill(backDiagonal, false);
    DFS(0);
  }


  public static void DFS(int indexQueen) {
    if (indexQueen == n + 1) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.print(map[i][j]);
        }
        System.out.println();
      }
    }
    // 第 indexQueen 行，第 c 列
    for (int c = 0; c < n; c++) {
      // diagonal[indexQueen + c]：第 indexQueen 行， 第 c 列，是否可以放皇后
      if (!col[indexQueen] && !diagonal[indexQueen + c] && !backDiagonal[c - indexQueen + n]) {
        map[indexQueen][c] = 'Q';
        col[indexQueen] = diagonal[indexQueen + c] = backDiagonal[c - indexQueen + n] = true;
        // 下一行
        DFS(indexQueen + 1);
        map[indexQueen][c] = '.';
        col[indexQueen] = diagonal[indexQueen + c] = backDiagonal[c - indexQueen + n] = false;
      }
    }
  }
}
