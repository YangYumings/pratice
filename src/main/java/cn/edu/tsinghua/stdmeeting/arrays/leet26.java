package cn.edu.tsinghua.stdmeeting.arrays;

public class leet26 {


  /**
   * 快慢指针，快指针遇到重复就跳过，慢指针遇到重复就覆盖
   *
   * @param nums
   * @return
   */
  public int removeDuplicates(int[] nums) {
    int len = nums.length;
    if (len < 2) {
      return len;
    }
    int slow = 0, fast = 1;
    int count = 1;
    while (fast < len && slow < len) {
      if (nums[slow] == nums[fast]) {
        fast++;
      } else {
        nums[++slow] = nums[fast++];
        count++;
      }
    }
    return count;
  }
}
