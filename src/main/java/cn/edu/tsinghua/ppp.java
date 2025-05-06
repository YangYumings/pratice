package cn.edu.tsinghua;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ppp {
  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};

    merge(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(nums1));
    System.out.println(Arrays.toString(nums3));
  }

  static int[] nums3;



  // Java 中所有的参数传递都是值传递，传递的是引用的一个复制体，因此你修改引用的指定并不会对原始的对象造成影响。
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    nums3 = new int[m + n];
    int i = 0, j = 0, k = 0;
    while (i < m && j < n) {
      if (nums1[i] < nums2[j]) {
        nums3[k++] = nums1[i++];
      }else {
        nums3[k++] = nums2[j++];
      }
    }
    while (i < m) {
      nums3[k++] = nums1[i++];
    }
    while (j < n) {
      nums3[k++] = nums2[j++];
    }
    Arrays.setAll(nums1, l -> nums3[l]);
  }

  public static void quickSort(int[] arr, int begin, int end) {
    if (begin <= end) {
      return;
    }
    int p = partition(arr, begin, end);
    quickSort(arr, begin, p - 1);
    quickSort(arr, p + 1, end);
  }

  public static int partition(int[] arr, int begin, int end) {
    int p = arr[begin];
    int l = begin, r = end;
    while (l != r) {
      while ((l < r) && (p < arr[r])) {
        r--;
      }
      while ((l < r) && (p >= arr[l])) {
        l++;
      }
      int temp = arr[l];
      arr[l] = p;
      p = temp;
    }
    return l;
  }

  static int N = 10;
  static int n;
  static char[][] map = new char[N][N];
  static boolean[] col = new boolean[N];
  static boolean[] diagonal = new boolean[N * 2];
  static boolean[] backDiagonal = new boolean[N * 2];

  public static void DFS(int indexQueen) {
    if (indexQueen == n + 1) {
      // 打印
    }
    for (int c = 0; c < n; c++) {
      if (!col[c] && !diagonal[c] && !backDiagonal[c]) {
        map[indexQueen][c] = 'Q';
        col[c] = diagonal[indexQueen + c] = backDiagonal[indexQueen - c + n] = true;
        //
        DFS(indexQueen + 1);
        col[c] = diagonal[indexQueen + c] = backDiagonal[indexQueen - c + n] = false;
        map[indexQueen][c] = '.';
      }
    }
  }

  static int n2, m2;
  static int[][] arr;
  static int[][] dis;
  static Queue<Pair> queue = new LinkedList<>();
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  public int BFS() {
    int x1 = 0;
    int y1 = 1;
    while (!queue.isEmpty()) {
      Pair cur = queue.poll();
      if (cur.first == n2 - 1 && cur.second == m2 - 1) {
        break;
      }
      for (int i = 0; i < 4; i++) {
        x1 = cur.first + dx[i];
        y1 = cur.second + dy[i];
        if (0 <= x1 && x1 < n2 && 0 <= y1 && y1 < m2) {
          dis[x1][y1] = dis[cur.first][cur.second] + 1;
          queue.offer(new Pair(x1, y1));
        }
      }
    }
    String temp = "";
    temp.length();
    return dis[n2 - 1][m2 - 1];
  }

  public class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  static int N2 = 100010;
  static int[] headNodeList = new int[N2];
  static int[] siblingEdge = new int[N2];
  static int[] endPointOfEdge = new int[N2];
  static int edgeNUmber = 0;

  public static void add(int start, int end) {
    endPointOfEdge[edgeNUmber] = end;
    siblingEdge[edgeNUmber] = headNodeList[start];
    headNodeList[start] = edgeNUmber++;
  }
}
