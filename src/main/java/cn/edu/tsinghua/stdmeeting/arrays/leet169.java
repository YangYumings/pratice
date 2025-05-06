package cn.edu.tsinghua.stdmeeting.arrays;

import java.util.Arrays;

public class leet169 {
  /**
   * 解题方法很多，这里只给出一种
   */
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}
