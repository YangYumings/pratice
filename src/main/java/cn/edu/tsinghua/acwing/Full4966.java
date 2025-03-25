package cn.edu.tsinghua.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Full4966 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static long count = 0;
  public static void main(String[] args) throws IOException {
    String str = br.readLine();
    for(int i = 0; i < str.length()-1; i ++){
      if(str.charAt(i) == str.charAt(i + 1) || str.charAt(i) == '?' || str.charAt(i + 1) == '?'){
        count ++;
        i++;
      }
    }
    System.out.println(count);
  }
}
