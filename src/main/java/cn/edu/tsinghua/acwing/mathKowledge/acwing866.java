package cn.edu.tsinghua.acwing.mathKowledge;

import java.util.Scanner;

public class acwing866 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n-- != 0) {
      int num = sc.nextInt();
      System.out.println(isPrime(num) ? "Yes" : "No");
    }
  }

  public static boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }
    for (int i = 2; i <= num / i; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
