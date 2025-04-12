package cn.edu.tsinghua.acwing.math;

import java.util.Scanner;

public class acwing875 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = 3;
    int b = 2;
    int p = 5;
    System.out.println();
    System.out.println(prim(a, b, p));
  }

  public static long prim(int a, int b, int p) {
    long cnt = 1 % p, t = a;
    while (b != 0) {
      if ((b & 1) == 1)
        cnt = (cnt * t) % p;
      t = t * t % p;
      b >>= 1;
    }
    return cnt;
  }
}
