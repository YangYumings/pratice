package cn.edu.tsinghua.stdmeeting.arrays;

public class leet80 {
  /**
   * 有序数组
   * 快慢指针 slow 指向下一个插入的位置，fast 寻找下一个插入的位置 slow - 2 的目的是未了判断是否重复的超过两个
   *
   * @param nums
   * @return
   */
  public int removeDuplicates(int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    }
    int slow = 2, fast = 2;
    while (fast < nums.length && slow < nums.length) {
      if (nums[slow - 2] == nums[fast]) {
        fast++;
      } else {
        nums[slow] = nums[fast];
        slow++;
        fast++;
      }
    }
    return slow;
  }
}
