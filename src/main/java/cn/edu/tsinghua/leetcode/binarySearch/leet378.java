package cn.edu.tsinghua.leetcode.binarySearch;

public class leet378 {
  public static void main(String[] args) {

  }

  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int left = matrix[0][0], right = matrix[n - 1][n - 1];
    while (left < right) {
      int mid = (right - left) / 2 + left;
      if (check(matrix, mid, k, n)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public boolean check(int[][] matrix, int mid, int k, int n) {
    int i = n - 1, j = 0;
    int count = 0;
    while (i >= 0 && j < n) {
      if (matrix[i][j] <= mid) {
        // 这里不会多加一次吗
        // 不会，是按列加的，不是按行加的
        count += i + 1;
        j++;
      } else {
        i--;
      }
    }
    return count >= k;
  }

  public int kthSmallest_2(int[][] matrix, int k) {
    // 订范围
    int after = 0;
    for (int i = 1; i <= matrix.length; i++) {
      if (k == i * i) {
        System.out.println(matrix[i - 1][i - 1]);
      } else if (k < i * i) {
        after = i - 1;
        break;
      }
    }
    // 合成数组
    int[] res = new int[2 * after];
    int m = 0;
    for (int i = 0; i < after; i++) {
      res[m++] = matrix[i][after];
      res[m++] = matrix[after][i];
    }
    res[m] = matrix[after][after];

    // 排序找k小
    return 1;
  }

}
