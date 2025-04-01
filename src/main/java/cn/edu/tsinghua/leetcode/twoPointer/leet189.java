package cn.edu.tsinghua.leetcode.twoPointer;

public class leet189 {
  public static void main(String[] args) {

  }

  public void rotate(int[] nums, int k) {
    int length = nums.length;
    k = k % length;
    reverse(nums, 0, length - k - 1);
    reverse(nums, length - k, length - 1);
    reverse(nums, 0, length - 1);
  }

  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}
