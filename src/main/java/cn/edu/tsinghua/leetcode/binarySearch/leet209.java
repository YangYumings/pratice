package cn.edu.tsinghua.leetcode.binarySearch;

import java.util.Arrays;

public class leet209 {
  public static void main(String[] args) {

  }
  public int minSubArrayLen(int target, int[] nums) {
    int[] prefixSum = new int[nums.length + 1];
    int ans = Integer.MAX_VALUE;

    for (int i = 1; i <= nums.length; i++){
      prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
    }

    for(int i = 1; i <= nums.length; i++){
      int value = prefixSum[i - 1] + target;
      int bound = Arrays.binarySearch(prefixSum, value);
      if(bound < 0){
        bound = -bound - 1;
      }
      if(bound <= nums.length){
        ans = Math.min(ans, bound- (i -1));
      }
    }
    return ans == Integer.MAX_VALUE ? 0 : ans;
  }
}
