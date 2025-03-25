package cn.edu.tsinghua.acwing.bfs;

import cn.edu.tsinghua.acwing.utils.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class acwing844 {
  static int n;
  static int m;
  static int[][] arr;
  static int[][] dis;
  static Queue<Pair> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    m = Integer.parseInt(line[1]);
    arr = new int[n][m];
    dis = new int[n][m];

    for (int i = 0; i < n; i++) {
      Arrays.fill(dis[i], -1);
    }

    for (int i = 0; i < n; i++) {
      String[] temp = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(temp[j]);
      }
    }

    queue.offer(new Pair(0, 0));

    System.out.println(BFS());
  }

  public static int BFS() {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int x1 = 0;
    int y1 = 0;

    while(!queue.isEmpty()){
      Pair cur = queue.poll();
      if (cur.first == n-1 && cur.second == m-1){
        break;
      }
      for (int i = 0; i < 4; i++) {
        x1 = cur.first + dx[i];
        y1 = cur.second + dy[i];
        if(x1 >= 0 && x1 < n && y1 >= 0 && y1 < m){
          dis[x1][y1] = dis[cur.first][cur.second] + 1;
          queue.offer(new Pair(x1, y1));
        }
      }
    }

    return dis[n-1][m-1];
  }

}
