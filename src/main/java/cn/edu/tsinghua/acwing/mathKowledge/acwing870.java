package cn.edu.tsinghua.acwing.mathKowledge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class acwing870 {
  static int n;
  static final int MOD = 1000000007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<Integer, Integer> map = new HashMap<>();
    n = Integer.parseInt(br.readLine());
    while (n-- != 0) {
      int value = Integer.parseInt(br.readLine());

      for (int i = 2; i <= value / i; i++) {
        while (value % i == 0) {
          map.put(i, map.getOrDefault(i, 0) + 1);
          value = value / i;
        }
      }
      if (value > 1)
        map.put(value, map.getOrDefault(value, 0) + 1);
    }
    long res = 1;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      res = res * (entry.getValue() + 1) % MOD;
    }
    System.out.println(res);
  }
}
