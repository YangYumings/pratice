package cn.edu.tsinghua.leetcode.hot;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leet239 {

  /**
   * 优先队列
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    int numsSize = nums.length;
    int[] res = new int[numsSize - k + 1];
    PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
      }
    });
    if (k == 0 || numsSize < k) {
      return null;
    }
    for (int i = 0; i < k; i++) {
      queue.offer(new int[]{nums[i], i});
    }

    res[0] = queue.peek()[0];
    for (int i = k; i < numsSize; i++) {
      queue.offer(new int[]{nums[i], i});
      while (queue.peek()[1] <= i - k) {
        queue.poll();
      }
      res[i - k + 1] = queue.peek()[0];
    }
    return res;
  }

  public static int[] maxSlidingWindow1(int[] nums, int k) {
    int numsSize = nums.length;
    if (k == 0 || numsSize < k) {
      return null;
    }

    int[] res = new int[numsSize - k + 1];
    int left = 0, right = k - 1;
    for (int i = 0; i < numsSize - k + 1; i++) {
      res[i] = nums[maxValueIndex(nums, left, right)];
      left++;
      right++;
    }

    return res;
  }


  public static int maxValueIndex(int[] nums, int left, int right) {
    int max = left;
    for (int i = left + 1; i <= right; i++) {
      if (nums[i] > nums[max]) {
        max = i;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;

    int[] res = maxSlidingWindow1(nums, k);
    for (int key : res) {
      System.out.println(key);
    }
  }
}