package cn.edu.tsinghua.leetcode.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class leet154 {
  static final int N = 5002;
  static int[] nums = new int[N];
  static int valueLast = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    for (int i = 0; i < line.length; i++) {
      nums[i] = Integer.parseInt(line[i]);
    }

    int value = nums[nums.length - 1];
    int l = 0, r = nums.length - 1;
    while(l < r) {
      int mid = (l + r) / 2;
      if (nums[mid] > value) {
        l = mid + 1;
      } else if (nums[mid] < value) {
        r = mid;
      } else {
        r -= 1;
      }
    }
    System.out.println(nums[l]);
  }
}
