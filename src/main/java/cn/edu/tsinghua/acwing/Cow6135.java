package cn.edu.tsinghua.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Cow6135 {
  static final int N = 7510;
  static int n;
  static int[] a = new int[N];
  static int[] b = new int[N];
  static int[] ans = new int[N];
  static int count  = 0;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    for (int i = 1; i <= n ; i++){
      a[i] = sc.nextInt();
    }
    for(int i = 1; i <= n; i++){
      b[i] = sc.nextInt();
      if(a[i] == b[i]){
        count ++;
      }
    }
    for (int i = 1; i <= n; i++ ){
      for(int j = 0;j < 2; j++){
        int sum  = count;
        for (int l = i, r = i + j; l>=1 && r <= n; l--, r++){
          if(a[l] == b[l]){
            sum --;
          }
          if(b[r] == a[r]){
            sum --;
          }
          if (a[l] == b[r]) {
            sum ++;
          }
          if(a[r] == b[l]){
            sum ++;
          }
          ans[sum]++;
        }
      }
    }
    for(int i = 0; i <= n; i++)
      System.out.println(ans[i]);
  }
}

