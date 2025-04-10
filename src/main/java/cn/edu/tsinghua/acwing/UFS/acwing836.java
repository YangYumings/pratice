package cn.edu.tsinghua.acwing.UFS;

import java.util.Scanner;

public class acwing836 {
  static int[] father;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


  }


  // 使用存储发起下标的方式实现并查集，能处理字符和整数，字符串还要重新优化。
  public static int find(int x){
    if(x != father[x])
      return father[x] = find(father[x]);
    return father[x];
  }

  public static void merge(int a, int b){
    if(find(a) != find(b)){
      father[find(a)] = find(b);
    }
  }

  public static boolean query(int a, int b){
    return find(a) == find(b);
  }
}
