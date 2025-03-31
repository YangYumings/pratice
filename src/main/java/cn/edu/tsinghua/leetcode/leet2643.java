package cn.edu.tsinghua.leetcode;

public class leet2643 {
  public static void main(String[] args) {
    int[][] num = {{0,0,0},{0,1,1}};
    rowAndMaximumOnes(num);
  }
  public static int[] rowAndMaximumOnes(int[][] mat) {
    // 遍历一次
    int max = 0;
    int column = 0;
    for(int i = 0; i < mat.length; i++){
      int sum = 0;
      for (int j = 0; j < mat[i].length; j++){
        sum += mat[i][j];
      }
      if(sum > max){
        max = sum;
        column = i;
      }
    }
    return new int[]{column, max};
  }
}
