package cn.edu.tsinghua.acwing.increment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acwing797 {
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int m = Integer.parseInt(line[1]);
    arr = new int[n];
    String[] line2 = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(line2[i]);
    }
    for (int j = 0; j < m; j++) {
      String[] line3 = br.readLine().split(" ");
      change(Integer.parseInt(line3[0]), Integer.parseInt(line3[1]), Integer.parseInt(line3[2]));
    }
    for (int i = 1; i < arr.length; i++) {
      arr[i] += arr[i - 1];
    }
  }
  public static void change(int l, int r, int value){
    arr[l] += value;
    if(r + 1 < arr.length){
      arr[r + 1] -= value;
    }
  }
}
