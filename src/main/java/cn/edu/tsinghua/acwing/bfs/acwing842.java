package cn.edu.tsinghua.acwing.bfs;

import java.util.Arrays;
import java.util.Scanner;

public class acwing842 {
  static int n;
  static boolean[] visited = new boolean[10];
  static int[] path = new int[10];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    DFS(1);
  }

  public static void DFS(int num){
    if(num == n + 1){
      for(int i = 0; i < n; i++){
        System.out.print(path[i] + " ");
      }
      System.out.println();
    }
    for(int i = 1; i <= n; i++){
      if(!visited[i]){
        // 当递归返回时（回溯），path[num] 会被覆盖或重置，从而生成新的排列。
        path[num] = i;
        visited[i] = true;
        DFS(i + 1);
        visited[i] = false;
      }
    }

  }

}
