package cn.edu.tsinghua.leetcode.math;

public class Exponentiation {
  public static long qmi(long a, long b, long p) {
    long ans = 1;
    while (b != 0) {
      if ((b & 1) == 1) {
        ans = ans * a % p;
      }
      a = a * a % p;
      b >>= 1;
    }
    return ans;
  }
}
