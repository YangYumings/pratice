package cn.edu.tsinghua.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Cake6118 {
  static Integer caseCount;
  static int arrLength;
  static int[] cakeArr = new int[100001];
  static long sumForA;
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    caseCount = sc.nextInt();
    while (caseCount-- > 0){
      arrLength = sc.nextInt();
      int length = arrLength / 2 + 1;
      int sumForA = Integer.MAX_VALUE;
      for(int i = 1;  i <= arrLength; i++){
        int value = sc.nextInt();
        cakeArr[i] = cakeArr[i -1] + value;
        if (i >= length){
          sumForA = Math.min(sumForA, cakeArr[i] - cakeArr[i - length]);
        }
      }
      int sumForB = cakeArr[arrLength] - sumForA;
      System.out.println(sumForA + " " + sumForB);
    }
  }
}
