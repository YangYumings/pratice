package cn.edu.tsinghua.acwing.package01;

import java.util.Scanner;

public class acwing2 {
  static int[][] state;
  static int[] value;
  static int[] weight;
  static int n;
  static int m;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    value = new int[n + 1];
    weight = new int[n + 1];
    // dp 数组 state[i][j]  表示 从下标为[0-i]的物品中任意选取，放进背包容量为 j 的背包中，价值总和的最大值为多少；
    state = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      String[] line = sc.nextLine().split(" ");
      weight[i] = Integer.parseInt(line[0]);
      value[i] = Integer.parseInt(line[1]);
    }
    //（背包放不下第 i 件物品时） 前 i 件物品最优解即为前 i-1 件物品的最优解
    // (放得下第 i 件物品时) 前 i 件物品的最优解为：前 i-1 件物品的最优解和第 i 件物品之和
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        // 递推公式
        if (j < weight[i]) {
          state[i][j] = state[i - 1][j];
        } else {
          state[i][j] = Math.max(state[i - 1][j], state[i - 1][j - weight[i]] + value[i]);
        }
      }
    }
    System.out.println(state[n][m]);
  }

}
