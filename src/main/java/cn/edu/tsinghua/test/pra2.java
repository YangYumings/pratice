package cn.edu.tsinghua.test;

import java.util.Scanner;

public class pra2 {
  public static void main(String[] args) {
    test_2();
  }

  public static void test_2() {
    // 1 到 202504  求位数和
    int count  = 0;
    for (int i = 5; i <= 202504; i++) {
      if(check(i)){
        count ++;
      }
    }
    System.out.println(count);
  }

  public static boolean check(int num) {
    int t = num;
    int sum = 0;
    while (t / 10 != 0) {
      sum += t % 10;
      t = t / 10;
    }
    sum += t;
    if(sum % 5 == 0){
      return true;
    }else{
      return false;
    }
  }
}
