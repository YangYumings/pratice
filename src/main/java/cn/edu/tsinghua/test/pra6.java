package cn.edu.tsinghua.test;

import java.util.Scanner;

public class pra6 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long x = sc.nextLong();
    long[] res = getLength(x- 1);
    long max = res[0];
    long offset = res[1];
    long len = res[2];
    long ans = 0;

    // 从 max 开始遍历， & 运算计算1的个数
    for (int i = 0; i <= max; i++) {
      ans += count1(i);
    }
    int[] arr = getBit(max + 1, (int) len);
    for (int i = 0, p = (int)len - 1 ; i < offset; i++) {
      if (arr[p--] == 1) {
        ans++;
      }
    }

    System.out.println(ans);
  }

  public static long[] getLength(long num) {
    long k = 1;
    long len = 1;
    long countBit = 0;
    // 算区间
    while (countBit <= num) {
      countBit += (len++) * k;
      k <<= 1;
    }
    // 计算区间起点数值
    long key = 0, temp = 1;
    for (int i = 0; i < len - 2; i++) {
      key += temp;
      temp <<= 1;
    }
    // 计算偏移量
    long st = countBit - (k / 2) * (len - 1);
    long num_1 = (num - st) / (len - 1);
    long offset = (num - (st + num_1 * (len + 1))) % (len - 1);
    return new long[]{key + num_1, offset, (len - 1)};
  }

  public static int count1(int num) {
    int ans = 0;
    while (num != 0) {
      if ((num & 1) == 1) {
        ans++;
      }
      num = num >> 1;
    }
    return ans;
  }

  public static int[] getBit(long num, int length) {
    int[] temp = new int[length];
    for (int k = 0; k < length && num != 0; k++) {
      temp[k] = (num & 1) == 1 ? 1 : 0;
      num = num >> 1;
    }
    return temp;
  }
}
