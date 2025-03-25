package cn.edu.tsinghua.acwing.increment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acwing798 {
  static int[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int m = Integer.parseInt(line[1]);
    int q = Integer.parseInt(line[2]);
    for (int i = 0; i < n; i++){
      String[] line2 = br.readLine().split(" ");
      for(int j = 0; j < m; j++){
        insert(i, j, i, j, Integer.parseInt(line2[j]));
      }
    }

    while(q-- != 0){
      String[] line3 = br.readLine().split(" ");
      insert(Integer.parseInt(line3[0]), Integer.parseInt(line3[1]), Integer.parseInt(line3[2]), Integer.parseInt(line3[3]), Integer.parseInt(line3[4]));
    }

    for (int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        arr[i][j] += arr[i -1][j] + arr[i][j-1] - arr[i - 1][j - 1];
      }
    }

  }

  public static void insert(int x1, int y1, int x2, int y2, int val) {
    arr[x1][y1] += val;
    arr[x2 + 1][y1] -= val;
    arr[x1][y2 + 1] -= val;
    arr[x2 + 1][y2 + 1] += val;
  }
}

