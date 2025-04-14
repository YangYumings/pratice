package cn.edu.tsinghua.acwing.package01;

import java.util.Scanner;

public class acwing3 {
  static int n;
  static int m;
  static int[][] state;
  static int[] weight;
  static int[] value;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    state = new int[n + 1][m + 1];
    weight = new int[n + 1];
    value = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      String[] line = sc.nextLine().split(" ");
      weight[i] = Integer.parseInt(line[0]);
      value[i] = Integer.parseInt(line[1]);
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        for (int k = 0; k * weight[i] <= j; k++) {
          // 让 state[i][j] 始终保持最大值
          state[i][j] = Math.max(state[i][j], state[i - 1][j - k * weight[i]] + value[i] * k);
        }
      }
    }

    System.out.println(state[n][m]);
  }
}
