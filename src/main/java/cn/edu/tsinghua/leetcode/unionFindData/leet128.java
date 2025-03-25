package cn.edu.tsinghua.leetcode.unionFindData;

import java.util.HashSet;
import java.util.Set;

public class leet128 {
  static int ans = 0;

  public static void main(String[] args) {
    int[] nums = {1, 0, 1, 2};
    longestConsecutive(nums);
  }

  public static int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    for (int num : set) {
      if (!set.contains(num - 1)) {
        int count = 1;
        while (set.contains(num + 1)) {
          count++;
          num++;
        }
        ans = Math.max(ans, count);
      }
    }
    return ans;
  }
}
