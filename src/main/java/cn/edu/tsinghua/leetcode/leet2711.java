package cn.edu.tsinghua.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leet2711 {
  public static void main(String[] args) {

  }

  public static int[][] differenceOfDistinctValues(int[][] grid) {
    int m = grid.length;
    int n = m > 0 ? grid[0].length : 0;
    int[][] topLeftPrefix = new int[m][n];
    int[][] bottomRightSuffix = new int[m][n];
    Map<Integer, Set<Integer>> s = new HashMap<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int key = i - j;
        Set<Integer> set = s.getOrDefault(key, new HashSet<>());
        topLeftPrefix[i][j] = set.size();
        set.add(grid[i][j]);
        s.put(key, set);
      }
    }

    s.clear();

    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        int key = i - j;
        Set<Integer> set = s.getOrDefault(key, new HashSet<>());
        bottomRightSuffix[i][j] = set.size();
        set.add(grid[i][j]);
        s.put(key, set);
        topLeftPrefix[i][j] = Math.abs(topLeftPrefix[i][j] - bottomRightSuffix[i][j]);
      }
    }
    return topLeftPrefix;
  }
}
