package cn.edu.tsinghua.acwing.unionFindData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acwing836 {
  static int n;
  static int m;
  static int[] father;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    m = Integer.parseInt(line[1]);

    for (int i = 0; i <= n; i++) {
      father[i] = i;
    }

    while (m-- != 0) {
      String[] line2 = br.readLine().split(" ");
      int a = Integer.parseInt(line2[1]);
      int b = Integer.parseInt(line2[2]);
      if (line2[0].equals('M')) {
        merge(a, b);
      } else if (line2[0].equals('Q')) {
        query(a, b);
      } else {
        System.out.println("Error!");
      }
    }
    return;
  }

  public static int find(int x) {
    if (x != father[x]) {
      return father[x] = find(father[x]);
    }
    return father[x];
  }

  public static void merge(int a, int b) {
    if (find(a) != find(b)) {
      father[find(a)] = find(b);
    }
  }

  public static void query(int a, int b) {
    if (find(a) == find(b)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

  }
}
