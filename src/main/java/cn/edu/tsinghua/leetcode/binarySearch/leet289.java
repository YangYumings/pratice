package cn.edu.tsinghua.leetcode.binarySearch;

public class leet289 {
  public static void main(String[] args) {

  }

  public int findDuplicate(int[] nums) {
    int left = 0, right = nums.length - 1;
    int ans = -1;
    while (left < right) {
      int numLessThanMid = 0;
      int mid = (left + right) / 2;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= mid) {
          numLessThanMid++;
        }
      }
      if (numLessThanMid > mid) {
        right = mid - 1;
        ans = mid;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }
}
