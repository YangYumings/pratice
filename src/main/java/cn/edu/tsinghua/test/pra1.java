package cn.edu.tsinghua.test;

import java.util.Scanner;

public class pra1 {
  static int N = 100010;

  public static void main(String[] args) {
    test_1();
  }

  public static void test_1() {
    // 输入
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    sc.close();
    // m 次处理数组
    while (m-- != 0) {
      for(int i = 0; i < n; i++){
        arr[i] = arr[i] * bitCount(arr[i]);
      }
    }
    // 输出
    StringBuilder sb = new StringBuilder();
    sb.append(arr[0]);
    for(int i = 1; i < n; i++){
      sb.append(" ").append(arr[i]);
    }
    System.out.println(sb.toString());
  }

  public static int bitCount(int num) {
    int t = num, count = 0;
    while (t != 0) {
      if ((t & 1) == 1) {
        count++;
      }
      t = t >> 1;
    }
    return count;
  }
}
