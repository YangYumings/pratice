package cn.edu.tsinghua.acwing.mathKowledge;

import java.util.Scanner;

public class acwing867 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n-- != 0) {
      int num = sc.nextInt();
      Factor(num);
    }
  }

  public static void Factor(int num) {
    for (int i = 2; i < num / i; i++) {
      if (num % i == 0) {
        int count = 0;
        while (num % i == 0) {
          num /= i;
          count++;
        }
        System.out.println(i + " " + count);
      }
    }
    if(num > 1){
      System.out.println(num +" "+ 1);
    }
    System.out.println();
  }
}
