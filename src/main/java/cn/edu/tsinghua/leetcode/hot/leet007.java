package cn.edu.tsinghua.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，
 * 判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * <p>
 * <p>
 * 思路： 遍历 + 双指针
 */
public class leet007 {
    static List<List<Integer>> answer = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        threeSum(nums);
        System.out.println();
    }

    public static void threeSum(int[] nums) {
        // 遍历 a
        for (int i = 0; i < nums.length; i++) {
            // 避免重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // b 是 left， c 是 right
            int right = nums.length - 1;
            int left = i + 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // sum == 0 满足条件，然后移动左右指针跳过重复的元素
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    answer.add(list);
                    // 接下来的两个是为了将 b c 的重复元素去除
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 注意将指针下移，因为重复的元素移除了，因此只移动一个指针是不会又满足条件的结果，所以两个指针同时移动
                    left++;
                    right--;
                } else if (sum < 0) {
                    // sum < 0，left 向右移动
                    left++;
                } else {
                    // sum > 0，right 向左移动
                    right--;
                }
            }
        }
    }
}
