package cn.edu.tsinghua.leetcode.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class leet153 {
  static final int N = 5002;
  static int[] arr = new int[N];
  static int valueLast = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    for (int i = 1; i <= line.length; i++) {
      arr[i] = Integer.parseInt(line[i - 1]);
    }
    valueLast = arr[line.length];
    int l = 1, r = line.length;
    while (l < r) {
      int mid = (l + r) / 2;
      if (arr[mid] >= valueLast) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    System.out.println(arr[l]);
  }
}
