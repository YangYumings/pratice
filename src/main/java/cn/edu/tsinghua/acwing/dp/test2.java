package cn.edu.tsinghua.acwing.dp;

import java.util.Arrays;

public class test2 {
  static int n = 6;
  static int[] dp = new int[n];
  static int[] arr = {2, 3, 3, 2, 3, 3};

  public static void main(String[] args) {
    if (n == 0)
      System.out.println(0);
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (gcd(arr[i], arr[j]) > 1) {
          dp[i] = Math.min(dp[i], dp[j] + 1);
        }
      }
      if (dp[i] == Integer.MAX_VALUE) {
        dp[i] = (i == 0 ? 1 : dp[i - 1] + 1);
      }
    }

    System.out.println(dp[n - 1]);
  }

  public static int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }

}
