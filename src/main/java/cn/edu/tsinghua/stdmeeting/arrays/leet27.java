package cn.edu.tsinghua.stdmeeting.arrays;

public class leet27 {

  /**
   * 1.移除元素
   * 遍历一次，使用快慢指针，对于不等于 val 的元素，将快指针的元素覆盖慢指针的元素
   */

  public int removeElement(int[] nums, int val) {
    int slow = 0, fast = 0;
    int count = 0;
    while (fast < nums.length && slow < nums.length) {
      if (nums[fast] != val) {
        nums[slow++] = nums[fast++];
        count++;
      } else {
        fast++;
      }
    }
    return count;
  }
}
