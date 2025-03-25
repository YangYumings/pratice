package cn.edu.tsinghua.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class apple5307 {
  static long n = 0;
  static long m = 0;
  static long count = 0;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws IOException {
    String[] line = br.readLine().split(" ");
    n = Integer.parseInt(line[0]);
    // 当前苹果数
    long num = n;

    while(num > 0){
      count ++;
      // 本次拿走的苹果数
      long accept = num % 3 == 0? num / 3 : num / 3 + 1;
      if(num % 3 == 1 && count == 0){
        // 拿到n号苹果
        m = count;
      }
      // 更新苹果数
      num = num - accept;
    }
    System.out.println(count + " " + m);
  }
}
