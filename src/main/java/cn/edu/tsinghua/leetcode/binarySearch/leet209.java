package cn.edu.tsinghua.leetcode.binarySearch;

import java.util.Arrays;

public class leet209 {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;
        int[] nums2 = {1, 4, 4};
        int target2 = 4;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;

        System.out.println(minSubArrayLen2(target1, nums1));

        System.out.println(minSubArrayLen2(target2, nums2));

        System.out.println(minSubArrayLen2(target3, nums3));
    }

    /**
     * 前缀和 + 二分查找
     *
     * 思想：
     * 在确定左边界后，使用二分法查找右边界。
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        // 在确定左边界的情况下
        for (int left = 1; left <= nums.length; left++) {
            int value = prefixSum[left - 1] + target;
            int right = Arrays.binarySearch(prefixSum, value);
            if (right < 0) {
                right = -right - 1;
            }
            if (right <= nums.length) {
                ans = Math.min(ans, right - (left - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 方法二：滑动窗口
     * 特殊情况：如果有负数怎么办？
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        // 滑动窗口的边界 [left, right]
        int left = 0;
        long sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
