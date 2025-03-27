package cn.edu.tsinghua.leetcode.binarySearch;

import java.util.TreeMap;

public class leet456 {
  public static void main(String[] args) {
    int[] nums = {3, 1, 4, 2};
    System.out.println(find132pattern1(nums));
  }

  public static boolean find132pattern1(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    for (int j = 1; j <= nums.length - 2; j++) {
      for (int i = 0; i <= j - 1; i++) {
        if (nums[i] < nums[j]) {
          for (int k = j + 1; k < nums.length; k++) {
            if (nums[k] < nums[j] && nums[k] > nums[i]) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  public static boolean find132pattern2(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    int min_i = nums[0];
    TreeMap<Integer, Integer> rightAll = new TreeMap<>();
    for (int k = 2; k < nums.length; k++) {
      rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
    }
    for (int j = 1; j <= nums.length - 2; j++) {
      if (min_i < nums[j]) {
        Integer next = rightAll.ceilingKey(min_i + 1);
        if (next != null && next < nums[j]) {
          return true;
        }
      }
      min_i = Math.min(min_i, nums[j]);
      rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
      if (rightAll.get(nums[j + 1]) == 0) {
        rightAll.remove(nums[j + 1]);
      }
    }
    return false;
  }
}
