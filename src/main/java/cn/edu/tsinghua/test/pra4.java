package cn.edu.tsinghua.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class pra4 {
  static int n;
  static boolean[] vis;
  static int[] res = new int[100010];
  static int l = 0;

  public static void main(String[] args) {
    test_4();
  }

  public static void test_4() {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    vis = new boolean[n + 1];
    getBit_1(n);

    int ans = 0;
    int k = 1;
    for (int i = l - 1; i >=  0; i--) {
      if (res[i] == 1) {
        ans += k;
      }
      k = k * 2;
    }
    System.out.println(ans);
  }

  public static void getBit_1(int num) {
    int[] arr2 = getLength(num);
    int count  = arr2[1];
    // 遍历所有数字
    for (int j = count; j > 0; j--) {
      // 二进制
      int len = getLength(j)[0];
      int[] temp = getBit(j, len);
      // 遍历子串
      for (int p = 0; p < len; p++) {
        int target = getNum(temp, p, len - 1);
        if (target <= n && !vis[target]) {
          vis[target] = true;
          // 反向相加
          add(temp, p, len - 1);
        }
      }
    }
  }

  public static int[] getLength(int num){
    // 最大数
    int count = 1;
    // i 就是位数的长度
    int i, m = 1;
    // 计算最大位数长度即可
    for (i = 1; num > count; i++) {
      m = m * 2;
      count += m;
    }
    return new int[]{i, count};
  }

  public static int[] getBit(int num, int length){
    int[] temp = new int[length];
    for (int k = 0; k <= length && num != 0; k++) {
      temp[k] = (num & 1) == 1 ? 1 : 0;
      num = num >> 1;
    }
    return temp;
  }

  public static int getNum(int[] arr, int st, int ed) {
    int sum = 0;
    int k = 1;
    for (int i = st; i <= ed; i++) {
      if (arr[i] == 1) {
        sum += k;
      }
      k = k * 2;
    }
    return sum;
  }

  public static void add(int[] arr, int st, int ed) {
    for (int i = ed; i >= st; i--) {
      res[l++] = arr[i];
    }
  }
}
