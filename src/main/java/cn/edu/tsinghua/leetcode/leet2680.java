package cn.edu.tsinghua.leetcode;

public class leet2680 {
  public static void main(String[] args) {

  }

  public long maximumOr(int[] nums, int k) {
    int n = nums.length;
    long[] suf = new long[n + 1];
    // 前缀异和
    long pre = 0;
    // 后缀异和
    for (int i = n - 1; i >= 0; i--) {
      suf[i] = suf[i + 1] | nums[i];
    }
    long ans = 0;
    for (int i = 0; i< n; i++){
      ans = Math.max(ans, pre | (long) nums[i] << k | suf[i + 1]);
      pre |= nums[i];
    }
    return ans;
  }
}
