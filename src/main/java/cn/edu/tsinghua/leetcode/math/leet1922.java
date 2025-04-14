package cn.edu.tsinghua.leetcode.math;

import java.util.Scanner;

public class leet1922 {

  static long mod = 1000000007;

  public static void main(String[] args) {
    long n = 1920;
    long evenNum = (n + 1) / 2;
    long oddNum = n - evenNum;
    long res1 = Exponentiation.qmi(5, evenNum, mod);
    long res2 = Exponentiation.qmi(4, oddNum, mod);
    System.out.println(((res1 * res2) % mod));
  }
}
