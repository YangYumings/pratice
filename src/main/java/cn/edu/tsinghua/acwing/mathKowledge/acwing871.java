package cn.edu.tsinghua.acwing.mathKowledge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class acwing871 {
  static int MOD = 1000000007;
  static Map<Integer, Integer> map = new HashMap<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n-- != 0) {
      int target = sc.nextInt();
      for (int i = 2; i <= target / i; i++) {
        while (target % i == 0) {
          map.put(i, map.getOrDefault(i, 0) + 1);
          target = target / i;
        }
        if (target > 1)
          map.put(target, map.getOrDefault(target, 0) + 1);
      }
    }
    long res = 1;
    for (int key : map.keySet()) {
      int p = map.get(key);
      long t = 1;
      while(t -- != 0){
        t = (t * key + 1) % MOD;
      }
      res = res * t % MOD;
    }
    System.out.println(res);
  }

}
