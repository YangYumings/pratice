package cn.edu.tsinghua.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class pipe5407 {
  static final int N = 100010;
  static int[] S = new int[N];//存放时间
  static int[] L = new int[N];//存放坐标
  static int n, len;
  static Piis1[] p = new Piis1[N];
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  //输入数据还是蛮多的，考虑快读，输出只有一个，可以用一般输出
  public static void main(String[] args) throws IOException {
    String[] s = in.readLine().split(" ");
    n = Integer.parseInt(s[0]);
    len = Integer.parseInt(s[1]);
    for (int i = 0; i < n; i++) {
      s = in.readLine().split(" ");
      L[i] = Integer.parseInt(s[0]);
      S[i] = Integer.parseInt(s[1]);
    }//接收数据完毕！！！
    long l = 1, r = (long) 2e9;
    while (l < r) {
      long mid = l + r >> 1;
      if (check(mid)) r = mid;
      else l = mid + 1;
    }//二分模板，用第一个。
    //具体而言，画一条时间轴，小于T的不满足，大于等于T的满足。T就真了右边部分第一个满足的点。
    //也就是左区间，所以第一个模板
    System.out.println(l);

  }

  private static boolean check(long mid) {
    // TODO Auto-generated method stub
    int k = 0;
    for (int i = 0; i < n; i++) {
      long d = mid - S[i];//d表示mid和打开时间的差值，小于0直接跳过
      if (d >= 0) {
        p[k++] = new Piis1((int) (L[i] - d), (int) (L[i] + d));
        //存放mid时间时每一个的区间，左右区间都更新了。
      }
    }
    boolean flag = false;
    Arrays.sort(p, 0, k);//排序
    if (p[0].l <= 1) {
      long st = p[0].l, end = p[0].r;//以第一个区间为基准进行区间合并。
      for (int j = 1; j < k; j++) {
        if (end < p[j].l - 1) {
          break;
        }//这个是基准区间的右边小于当前区间-1，说明有空隙，直接退出。
        //千万注意是小于1哦，和区间合并时的相邻略有差别
        end = Math.max(end, p[j].r);//更新基准区间的右边就可以了！
      }//这个for循环是遍历后面k-1个区间
      if (end >= len) flag = true;
    }//如果第一个最左边都大于1，显然就不可能满足，直接返回false
    return flag;
  }
}

class Piis1 implements Comparable<Piis1> {
  int l;
  int r;

  public Piis1(int l, int r) {
    this.l = l;
    this.r = r;

  }

  @Override
  public int compareTo(Piis1 o) {
    return Integer.compare(l, o.l);
  }
}//这个相当于c++里的piis,重写compareTo作用使左区间升序排序