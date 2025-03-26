package cn.edu.tsinghua.leetcode;

public class leet2829 {
  public static void main(String[] args) {
    int res = minimumSum(5, 4);
  }
  public static int minimumSum(int n, int k) {
    int a = k / 2;
    int sum = 0, i = 1;
    while(n != 0){
      if(i <= a || i >= k){
        n -- ;
        sum += i;
      }
      i ++;
    }
    return sum;
  }
}
