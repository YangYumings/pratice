package cn.edu.tsinghua.leetcode.binarySearch;

public class leet754 {
  public static void main(String[] args) {

  }

  public int reachNumber(int target) {
    int t = Math.abs(target);
    int num = 0, result = 0;
    while (num < t || (num - t) % 2 != 0) {
      num += ++result;
    }
    return result;
  }
}
