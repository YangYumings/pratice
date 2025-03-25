package cn.edu.tsinghua.leetcode.binarySearch;

public class leet81 {
  public static void main(String[] args) {

  }
  public boolean search(int[] nums, int target) {
    int length = nums.length;
    int l = 0, r = length - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (nums[mid] == target){
        return true;
      }
      if(nums[mid] == nums[l] && nums[mid] == nums[r]){
        l++;
        r--;
      }else if(nums[mid] >= nums[l]){
        if(nums[mid] > target && nums[l] <= target){
          r = mid - 1;
        }else{
          l = mid + 1;
        }
      }else if(nums[mid] < nums[r]){
        if(nums[mid] < target && nums[r] >= target){
          l = mid + 1;
        }else{
          r = mid - 1;
        }
      }
    }
    return false;
  }
}
