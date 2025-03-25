package cn.edu.tsinghua.acwing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MouJiaoTime6134 {
  static int n;
  static int[] arr = new int[2000000];
  static int[] left = new int[2000000];
  static int[] right = new int[2000000];
  static int count = 0;
  static long res = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    for (int i = 1; i <= n; i++){
      int value = sc.nextInt();
      arr[i] = value;
      if (++ left[value] == 1){
        count ++;
      }
    }

    for (int i = n; i > 0; i--){
      if(-- left[arr[i]] == 0){
        count --;
      }
      if(++ right[arr[i]] == 2){
        res += count;
        if (left[arr[i]] != 0){
          res --;
        }
      }
    }
    System.out.println(res);
  }
}

