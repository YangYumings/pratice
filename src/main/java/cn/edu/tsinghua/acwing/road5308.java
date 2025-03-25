package cn.edu.tsinghua.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class road5308 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static long n = 0;
  static long d = 0;
  static long sum = 0;
  static boolean flag = true;
  static List<Integer> v = new ArrayList<>();
  static List<Integer> a = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    String[] line = br.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    d = Integer.parseInt(line[1]);
    // 读距离
    line = br.readLine().split(" ");
    for (String part : line) {
      v.add(Integer.parseInt(part));
    }
    // 距离前缀和
    for (int i = 1; i < v.size(); i++) {
      v.set(i, v.get(i) + v.get(i - 1));
    }
    // 读油价
    line = br.readLine().split(" ");
    for (String part : line) {
      a.add(Integer.parseInt(part));
    }
    // 最后一战一定不加油
    a.remove(a.size() - 1);
    // 最小油价的站到最后一站需要的油，最好在最小油价买
    int minValue = Collections.min(a);
    int minIndex = a.indexOf(minValue);
    int preMinValue = a.size();
    // 也可以每次删除数据，当数组不为空则循环
    while (flag) {
      long first;
      if (minIndex == 0) {
        flag = false;
        first = 0;
      } else {
        // 向上取整
        first = (v.get(minIndex - 1) + d - 1) / d;
      }
      sum += ((v.get(preMinValue - 1) + d - 1) / d - first) * minValue;
      // 找最小的油价
      if (minIndex != 0) {
        preMinValue = minIndex;
        minValue = Collections.min(a.subList(0, minIndex));
        minIndex = a.indexOf(minValue);
      }
    }
    System.out.println(sum);
  }
}
