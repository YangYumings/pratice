package cn.edu.tsinghua.leetcode.binarySearch;

public class leet400 {
  public static void main(String[] args) {
    System.out.println(findNthDigit(11));
  }

  public static int findNthDigit(int n) {
    int digit = 1;
    int start = 1;
    int num = n;
    if(num < 9){
      return num;
    }
    while (num > 9 * start * digit){
      num -= 9 * start * digit;
      digit ++;
      start *= 10;
    }
    int target = start + (num - 1) / digit;
    int k = (num - 1) % digit;
    return Long.toString(target).charAt(k) - '0';
  }
}
