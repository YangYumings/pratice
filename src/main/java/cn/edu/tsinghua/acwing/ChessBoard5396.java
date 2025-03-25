package cn.edu.tsinghua.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChessBoard5396 {
  static final Integer MAX = 2010;
  static Integer[][] diff = new Integer[MAX][MAX];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    final int N = Integer.parseInt(line[0]);
    final int M = Integer.parseInt(line[1]);
    // diff 赋值0，初始化矩阵
    for (int i = 0; i < MAX; i++) {
      Arrays.fill(diff[i], 0);
    }
    // 构建差分矩阵（标注哪些区域需要增删）
    for (int i = 0; i < M; i++) {
      String[] temp = br.readLine().split(" ");
      insert(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), 1);
    }
    // 求前缀和
    for(int i = 1; i <= N; i++){
      for(int j = 1; j <= N; j++ ){
        diff[i][j] += diff[i][j - 1] + diff[i - 1][j] - diff[i - 1][j - 1];
        System.out.print(diff[i][j] & 1);
      }
      System.out.println();
    }

  }

  public static void insert(int x1, int y1, int x2, int y2, int val){
    diff[x1][y1] += val;
    diff[x2 + 1][y1] -= val;
    diff[x1][y2 + 1] -= val;
    diff[x2 + 1][y2 + 1] += val;
  }
}
