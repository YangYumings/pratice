package cn.edu.tsinghua.leetcode.binarySearch;

import java.util.Arrays;

public class leet436 {
  public static void main(String[] args) {

  }

  public int[] findRightInterval(int[][] intervals) {
    int n = intervals.length;
    int[][] startPoints = new int[n][2];

    for (int i = 0; i < n; i++) {
      startPoints[i][0] = intervals[i][0];
      startPoints[i][1] = i;
    }

    Arrays.sort(startPoints, (o1, o2) -> o1[0] - o2[0]);

    int[] targets = new int[n];
    for (int i = 0; i < n; i++) {
      int left = 0, right = n - 1;
      int target = -1;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (startPoints[mid][0] >= intervals[i][1]) {
          target = startPoints[mid][1];
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      targets[i] = target;
    }
    return targets;
  }
}
