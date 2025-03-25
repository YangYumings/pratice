package cn.edu.tsinghua.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chess6122 {
  static int N;
  static int Q;
  static int res = 0;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws IOException {
    String[] line = br.readLine().split(" ");
    N = Integer.parseInt(line[0]);
    Q = Integer.parseInt(line[1]);
    int[][] arrXY = new int[N+1][N+1];
    int[][] arrYZ = new int[N+1][N+1];
    int[][] arrXZ = new int[N+1][N+1];
    for (int i = 0; i < Q; i++){
      line = br.readLine().split(" ");
      int xIndex = Integer.parseInt(line[0]);
      int yIndex = Integer.parseInt(line[1]);
      int zIndex = Integer.parseInt(line[2]);
      arrXY[xIndex][yIndex] ++;
      arrYZ[yIndex][zIndex] ++;
      arrXZ[xIndex][zIndex] ++;
      if(arrXY[xIndex][yIndex] >= N){
        res++;
      }
      if (arrYZ[yIndex][zIndex] >= N) {
        res++;
      }
      if (arrXZ[xIndex][zIndex] >= N) {
        res++;
      }
      System.out.println(res);
    }
  }
}
