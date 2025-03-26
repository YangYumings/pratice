package cn.edu.tsinghua.acwing.mathKowledge;

import java.util.Arrays;
import java.util.Scanner;

public class acwing868 {
  static boolean[] isPrime;
  static int[] primeArr;
  public static void main(String[] args) {
    Scanner sc =new Scanner(System.in);
    int n = sc.nextInt();
    isPrime = new boolean[n + 1];
    primeArr = new int[n + 1];
    Arrays.fill(isPrime, false);
    prime(n);
  }
  public static void prime(int n){
    int k = 0;
    for(int i = 2; i <= n; i++){
      if(!isPrime[i]){
        primeArr[k ++] = i;
        for(int j = i; j <=n; j += i){
          isPrime[j] = true;
        }
      }
    }
    System.out.println(k);
  }
}
