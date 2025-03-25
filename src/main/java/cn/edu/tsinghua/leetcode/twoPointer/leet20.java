package cn.edu.tsinghua.leetcode.twoPointer;

public class leet20 {
  public static void main(String[] args) {
    int[] nums = new int[]{1, 1, 1, 2, 2, 3};
    removeDuplicates(nums);
  }

  public static int removeDuplicates(int[] nums) {
    // 新数组长度
    int res;
    if (nums.length <= 2) {
      return nums.length;
    }
    int slow = 2, fast = 2;
    while (fast < nums.length) {
      if (nums[slow - 2] == nums[fast]){
        fast++;
      }else{
        nums[slow] = nums[fast];
        slow ++;
        fast ++;
      }
    }
    res = slow;
    return res;
  }

}
