package cn.edu.tsinghua.acwing.BIT;

import java.util.Arrays;
import java.util.Scanner;

// 楼兰图腾
public class acwing241 {
  static int N = 8;
  static int[] Lower = new int[N];
  static int[] Upper = new int[N];
  static int[] a = new int[N];
  static int[] t = new int[N];
  static int n;

  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    n = sc.nextInt();
    n = 5;
    int[] arr = new int[]{0, 1, 5, 3, 2, 4};
//    int[] arr = new int[n + 1];
//    for (int i = 0; i <= n; i++) {
//      arr[i] = sc.nextInt();
//    }

    for (int i = 1; i <= n; i++) {
      int y = arr[i];
      Lower[i] = ask(y - 1);
      Upper[i] = ask(n) - ask(y - 1);
      // 就是为了用 log(n) 的时间求前缀和（小于 y 的个数）
      add(y, 1);
    }

    Arrays.fill(t, 0);

    long resA = 0;
    long resV = 0;
    for (int i = n; i >= 1; i--) {
      int y = arr[i];
      resA += (long) Lower[i] * ask(y - 1);
      resV += (long) Upper[i] * (ask(n) - ask(y));
      add(y, 1);
    }

    System.out.println(resV);
    System.out.println(resA);
  }

  public static int lowBit(int x) {
    return x & -x;
  }

  public static int ask(int x) {
    int res = 0;
    for (int i = x; i > 0; i -= lowBit(i))
      res += t[i];
    return res;
  }

  public static void add(int x, int k) {
    for (int i = x; i <= n; i += lowBit(i))
      t[i] += k;
  }
}
