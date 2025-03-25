package cn.edu.tsinghua.acwing.bfs;

import javax.management.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class acsing845 {
  static Map<String, Integer> dis = new HashMap<>();
  static Queue<String> queue = new LinkedList<>();
  static String target = "12345678x";
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        sb.append(line[j]);
      }
    }
    BFS(sb.toString());
  }

  public static void BFS(String str) {
    dis.put(str, 0);
    queue.offer(str);

    while (!queue.isEmpty()) {
      String cur = queue.poll();

      if (cur.equals(target)) {
        System.out.println(dis.get(target));
        return;
      }

      int index = cur.indexOf('x');
      int distance = dis.get(cur);

      int x1 = index / 3;
      int y1 = index % 3;

      int x2, y2;
      for (int i = 0; i < 4; i++) {
        x2 = x1 + dx[i];
        y2 = y1 + dy[i];
        if (0 <= x2 && x2 < 3 && 0 <= y2 && y2 < 3) {
          cur = swap(cur, index, x2 * 3 + y2);
          if (!dis.containsKey(cur)) {
            dis.put(cur, distance + 1);
            queue.offer(cur);
          }
          cur = swap(cur, index, x2 * 3 + y2);
        }
      }
    }
  }

  public static String swap(String str, int index1, int index2) {
    StringBuilder sb = new StringBuilder(str);
    char a = sb.charAt(index1);
    char b = sb.charAt(index2);
    sb.setCharAt(index1, b);
    sb.setCharAt(index2, a);
    return sb.toString();
  }

}
