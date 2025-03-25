package cn.edu.tsinghua.acwing.bfs;

import java.util.Arrays;
import java.util.Scanner;

public class acwing843 {
  static int N = 10;
  static int n;
  static char[][] map = new char[N][N];
  static boolean[] col = new boolean[N];
  static boolean[] diagonal = new boolean[2 * N];
  static boolean[] backDiagonal = new boolean[2 * N];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = '.';
      }
    }
    Arrays.fill(col, false);
    Arrays.fill(diagonal, false);
    Arrays.fill(backDiagonal, false);
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
    for (int c = 0; c < n; c++) {
      if (!col[indexQueen] && !diagonal[indexQueen + c] && !backDiagonal[c - indexQueen + n]) {
        map[indexQueen][c] = 'Q';
        col[indexQueen] = diagonal[indexQueen + c] = backDiagonal[c - indexQueen + n] = true;
        DFS(indexQueen + 1);
        map[indexQueen][c] = '.';
        col[indexQueen] = diagonal[indexQueen + c] = backDiagonal[c - indexQueen + n] = false;
      }
    }
  }
}
