package cn.edu.tsinghua.acwing.mathKowledge;

import java.util.Scanner;

public class acwing872 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while(n-- != 0){
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(gcd(a, b));
    }
  }
  public static int gcd(int a, int b){
    return b != 0 ? gcd(b, a % b) : a;
  }
}
