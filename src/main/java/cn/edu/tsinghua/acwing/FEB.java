package cn.edu.tsinghua.acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FEB {
  static int max;
  static int min;
  static int l;
  static int r;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int N = Integer.parseInt(br.readLine());
    String str = br.readLine();
    char[] temp = str.toCharArray();
    char[] tempCopy = temp.clone();
    l = 0;
    r = N - 1;
    while (l < N && temp[l] == 'F') {
      l++;
    }
    while (r >= 0 && temp[r] == 'F') {
      r--;
    }
    // 数据公差
    final int d = (temp[0] == 'F' || temp[N - 1] == 'F') ? 1 : 2;
    for(int i = l; i <= r; i ++){
      if(tempCopy[i] == 'F'){
        if(tempCopy[i-1] == 'E'){
          tempCopy[i] = 'B';
        }else {
          tempCopy[i] = 'E';
        }
      }
    }
    for(int i = l; i <= r-1; i ++){
      if(tempCopy[i] == tempCopy[i+1]){
        min++;
      }
    }

    for(int i = l; i <= r; i ++){
      if(temp[i] =='F'){
        temp[i] = temp[i-1];
      }
    }
    for(int i = l; i <= r-1; i ++){
      if(temp[i]==temp[i+1]){
        max++;
      }
    }

    if(l == N) l--;
    max += l;
    if(l <= r){
      max += N-1-r;
    }
    System.out.println((max-min)/d +1);
    for (int i = min; i <= max; i += d){
      System.out.println(i);
    }
  }
}
