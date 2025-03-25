package cn.edu.tsinghua.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ErFen789 {
  static final int N = 100000;
  static int length = 0;
  static int query = 0;
  static int arr[] = new int[N];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    length = Integer.parseInt(line[0]);
    query = Integer.parseInt(line[1]);
    String[] line2 = br.readLine().split(" ");
    for (int i = 1; i <= length; i++) {
      arr[i] = Integer.parseInt(line2[i - 1]);
    }
    for (int i = 1; i <= query; i++) {
      int value = Integer.parseInt(br.readLine());
      int l = 1, r = length;
      while (l < r) {
        int mid = (l + r) / 2;
        // 左区间不成立、右区间成立
        // 那每次缩小左区间时，当前值也是不满足条件的，因此 l = mid + 1；
        // 每次缩小右区间时，当前值是满足条件的，要保留，因此 r = mid；
        if (arr[mid] >= value) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
      if (arr[l] != value) {
        System.out.println("-1 -1");
      } else {
        System.out.print((l-1) + " ");
        l = 1;
        r = length;
        // 左区间成立、右区间不成立
        // 每次缩小左区间时，当前值是满足条件的，要保留，因此 l = mid；
        // 每次缩小右区间时，当前值是不满足条件的，因此 r = mid - 1；
        // 加 1 的原因是,当r-l等于1时,mid等于l,而更新时 l 还是等于 mid(l),导致死循环,区间为【l, r】;
        // 加1的原因是让其向上取整，让r-l等于1时，更新后的 mid 为 r,最终区间在 【r，r】中止。
        while (l < r) {
          int mid = (l + r + 1) / 2;
          if (arr[mid] <= value) {
            l = mid;
          } else {
            r = mid - 1;
          }
        }
        System.out.println(l-1);
      }
    }
  }
}

