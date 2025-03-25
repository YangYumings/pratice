package cn.edu.tsinghua.leetcode.binarySearch;

public class leet162 {
  public static void main(String[] args) {

  }

  public int findPeakElement(int[] nums) {
    int length = nums.length;
    int l = 0, r = length - 1;
    int mid = 0;
    while (l <= r) {
      mid = (l + r) / 2;
      if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
        return mid;
      }
      if (nums[mid] < nums[mid + 1]){
        l = mid + 1;
      }else if(nums[mid] < nums[mid -1]){
        r = mid -1;
      }
    }
    return l;
  }
}
