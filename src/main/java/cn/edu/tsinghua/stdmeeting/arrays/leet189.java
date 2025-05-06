package cn.edu.tsinghua.stdmeeting.arrays;

public class leet189 {

  /**
   * 数组轮转
   * 三次翻转
   *
   * @param nums
   * @param k
   */
  public void rotate(int[] nums, int k) {
    int len = nums.length;
    reverse(nums, 0, len - k - 1);
    reverse(nums, len - k, len - 1);
    reverse(nums, 0, len - 1);
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
