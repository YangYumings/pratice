package cn.edu.tsinghua.leetcode.prefix;

public class leet238 {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    int[] res = productExceptSelf(nums);
    System.out.println(res);
  }

  public static int[] productExceptSelf(int[] nums) {
    int[] arr1 = new int[nums.length + 1];
    int[] arr2 = new int[nums.length + 1];
    int[] ans = new int[nums.length];

    arr1[0] = 1;
    arr2[nums.length] = 1;

    for (int i = 1; i <= nums.length; i++) {
      arr1[i] = arr1[i - 1] * nums[i - 1];
    }
    for (int i = nums.length - 1; i >= 0; i--) {
      arr2[i] = arr2[i + 1] * nums[i];
    }

    for (int i = 0; i < nums.length; i++) {
      ans[i] = arr1[i] * arr2[i + 1];
    }
    return ans;
  }
}
