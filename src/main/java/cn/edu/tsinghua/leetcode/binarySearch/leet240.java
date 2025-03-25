package cn.edu.tsinghua.leetcode.binarySearch;

public class leet240 {
  public static void main(String[] args) {

  }

  public boolean searchMatrix(int[][] matrix, int target) {
    for (int[] ints : matrix) {
      int left = 0, right = matrix[0].length - 1;
      while (left < right) {
        int mid = (left + right) / 2;
        if (ints[mid] == target) {
          return true;
        } else if (ints[mid] > target) {
          right = mid - 1;
        } else {
          left = mid;
        }
      }
      if (ints[left] == target) {
        return true;
      }
    }
    return false;
  }
}
