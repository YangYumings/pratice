package cn.edu.tsinghua.acwing.mathKowledge;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class acwing869 {
  static List<Integer> divisors = new ArrayList<>();
  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    while (n-- != 0) {
      int value = Integer.parseInt(br.readLine());
      divide(value);
    }
  }

  public static void divide(int value) {
    divisors.clear();
    for (int i = 1; i <= value / i; i++) {
      if (value % i == 0) {
        divisors.add(i);
        if (value / i != i) {
          divisors.add(value / i);
        }
      }
    }
    Collections.sort(divisors);
    for (int i = 0; i < divisors.size(); i++) {
      System.out.print(divisors.get(i) + " ");
    }
    System.out.println();
  }
}
