package cn.edu.tsinghua.acwing.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 判断是否是二分图
public class acwing846 {
  static int N = 100010;
  // 邻接表头节点，存储最新边的序号，这个结构的下标就是边的起点
  static int[] headNodeList = new int[N];
  // 存储每条边的终点，根据边的序号就可以知道边的终点
  static int[] endPointOfEdge = new int[N];
  // 兄弟节点的边：同起点的不同点
  static int[] sibling = new int[N];
  static int edgeNumber = 0;

  static int[] dis = new int[N];
  static boolean[] vis = new boolean[N];
  static int n, m;
  static int ans = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    m = Integer.parseInt(line[1]);
    Arrays.fill(headNodeList, -1);
    Arrays.fill(dis, Integer.MAX_VALUE);
    while (m-- != 0) {
      line = br.readLine().split(" ");
      int a = Integer.parseInt(line[0]);
      int b = Integer.parseInt(line[1]);
      add(a, b);
    }
    bfs();
    Integer res = dis[n] == Integer.MAX_VALUE ? -1 : dis[n];
    System.out.println(res);
  }

  public static void bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);
    dis[1] = 0;
    vis[1] = true;
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      for (int edgeIndex = headNodeList[curr]; edgeIndex != -1; edgeIndex = sibling[edgeIndex]) {
        int nodeNumber = endPointOfEdge[edgeIndex];
        if (!vis[nodeNumber]) {
          dis[nodeNumber] = dis[curr] + 1;
          queue.offer(nodeNumber);
          vis[nodeNumber] = true;
        }
      }
    }
  }

  public static int dfs(int curr) {
    int res = 0;
    vis[curr] = true;
    int sum = 1;
    for (int edgeIndex = headNodeList[curr]; edgeIndex != -1; edgeIndex = sibling[edgeIndex]) {
      int nodeNumber = endPointOfEdge[edgeIndex];
      if (!vis[nodeNumber]) {
        dis[nodeNumber] = dis[curr] + 1;
        int s = dfs(nodeNumber);
        res = Math.max(s, res);
        sum += s;
      }
    }
    res = Math.max(res, n - sum);
    ans = Math.min(res, ans);
    return sum;
  }

  // 有向图加一次，无向图加两次。
  public static void add(int a, int b) {
    endPointOfEdge[edgeNumber] = b;
    sibling[edgeNumber] = headNodeList[a];
    headNodeList[a] = edgeNumber++;
  }
}
